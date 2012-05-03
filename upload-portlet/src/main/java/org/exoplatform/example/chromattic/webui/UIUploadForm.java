package org.exoplatform.example.chromattic.webui;

import java.io.File;
import java.io.FileInputStream;

import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.xml.namespace.QName;

import org.exoplatform.example.chromattic.entities.Gallery;
import org.exoplatform.example.chromattic.entities.Model;
import org.exoplatform.example.chromattic.entities.Photo;
import org.exoplatform.example.chromattic.services.MOBService;
import org.exoplatform.example.chromattic.validator.MimeTypesValidator;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;
import org.exoplatform.upload.UploadResource;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.ComponentConfigs;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIForm;
import org.exoplatform.webui.form.UIFormStringInput;
import org.exoplatform.webui.form.UIFormUploadInput;

@ComponentConfigs({ @ComponentConfig(lifecycle = UIFormLifecycle.class, template = "app:/groovy/webui/UploadPortlet/UIUploadForm.gtmpl", events = { @EventConfig(listeners = UIUploadForm.SaveActionListener.class) }) })
public class UIUploadForm extends UIForm {
	
	public UIUploadForm() throws Exception {
		addUIFormInput(new UIFormStringInput("name", "name", null));
		UIFormUploadInput uploadInput = new UIFormUploadInput("upload",	"upload");
		uploadInput.setAutoUpload(true);
		uploadInput.addValidator(MimeTypesValidator.class, "image/jpeg");
		addUIFormInput(uploadInput);
	}

	static public class SaveActionListener extends EventListener<UIUploadForm> {
		public void execute(Event<UIUploadForm> event) throws Exception {

			UIUploadForm uiForm = event.getSource();
			UIFormStringInput uiName = (UIFormStringInput) uiForm.getUIInput("name");
			UIFormUploadInput uiUploadInput = (UIFormUploadInput) uiForm.getUIInput("upload");
			
			UploadResource uploadResource = uiUploadInput.getUploadResource();			
			if (uploadResource != null && uploadResource.getUploadedSize() > 0) {
				String photoName = uploadResource.getFileName();
				if (uiName.getValue() != null && uiName.getValue().length() > 0) {
					photoName = uiName.getValue();
				}
				
				PortletRequestContext portletRequestContext = WebuiRequestContext.getCurrentInstance();
		        PortletPreferences preferences = portletRequestContext.getRequest().getPreferences();
		        String folderPath = preferences.getValue("galleryPath", "sites content/live/acme/documents");
		        MOBService mobService = WCMCoreUtils.getService(MOBService.class);
		        Model model = mobService.getModel();
		        Gallery gallery = model.getGallery(folderPath);
				
				if (!gallery.getPhotoMap().containsKey(photoName)) {
					Photo photo = gallery.createPhoto();
					photo.setName(photoName);
					gallery.getPhotoMap().put(photo.getName(), photo);
					photo.update(uploadResource.getMimeType(), new FileInputStream(new File(uploadResource.getStoreLocation())));
				}
				
				uiName.reset();
				uiForm.removeChild(UIFormUploadInput.class);
				UIFormUploadInput uploadInput = new UIFormUploadInput("upload",	"upload");
				uploadInput.setAutoUpload(true);
				uploadInput.addValidator(MimeTypesValidator.class, "image/jpeg");
				uiForm.addUIFormInput(uploadInput);

			}
			
			ActionResponse actResponse = event.getRequestContext().getResponse();
	        actResponse.setEvent(new QName("NewPhotoUploaded"), null);
		}
	}
}
