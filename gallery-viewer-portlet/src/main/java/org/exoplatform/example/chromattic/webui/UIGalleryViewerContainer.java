package org.exoplatform.example.chromattic.webui;

import java.util.Map;

import javax.portlet.PortletPreferences;

import org.exoplatform.example.chromattic.entities.Gallery;
import org.exoplatform.example.chromattic.entities.Model;
import org.exoplatform.example.chromattic.entities.Photo;
import org.exoplatform.example.chromattic.services.MOBService;
import org.exoplatform.portal.webui.container.UIContainer;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.lifecycle.Lifecycle;

@ComponentConfig(
	    lifecycle = Lifecycle.class,
	    template = "app:/groovy/webui/GalleryViewer/UIGalleryViewerContainer.gtmpl"
	)
public class UIGalleryViewerContainer extends UIContainer{
	
	private Map<String, Photo> photoMap;
	
	public UIGalleryViewerContainer () throws Exception{
		super();
	}	
	
	public String getDateTimeFormat() {
		return getAncestorOfType(UIGalleryViewerPortlet.class).getDateTimeFormat();
	}
	
	public Map<String, Photo> getPhotoMap() {
		return photoMap;
	}

	public void setPhotoMap(Map<String, Photo> photoMap) {
		this.photoMap = photoMap;
	}

	public void processRender(WebuiRequestContext context) throws Exception {
		PortletRequestContext portletRequestContext = WebuiRequestContext.getCurrentInstance();
        PortletPreferences preferences = portletRequestContext.getRequest().getPreferences();
        String folderPath = preferences.getValue("galleryPath", "sites content/live/acme/documents");
        MOBService mobService = WCMCoreUtils.getService(MOBService.class);
        Model model = mobService.getModel();
        Gallery gallery = model.getGallery(folderPath);
		this.photoMap = gallery.getPhotoMap();
		super.processRender(context);
	}

}
