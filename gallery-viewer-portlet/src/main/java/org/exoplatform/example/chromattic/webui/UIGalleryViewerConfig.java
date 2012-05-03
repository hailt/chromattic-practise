package org.exoplatform.example.chromattic.webui;

import javax.portlet.PortletPreferences;

import org.exoplatform.ecm.webui.selector.UISelectable;
import org.exoplatform.wcm.webui.Utils;
import org.exoplatform.wcm.webui.selector.content.UIContentSelector;
import org.exoplatform.wcm.webui.selector.content.folder.UIContentBrowsePanelFolder;
import org.exoplatform.wcm.webui.selector.content.folder.UIContentSelectorFolder;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIPopupContainer;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIForm;
import org.exoplatform.webui.form.UIFormStringInput;

@ComponentConfig(
	    lifecycle = UIFormLifecycle.class,
	    template = "app:/groovy/webui/GalleryViewer/UIGalleryViewerConfig.gtmpl",
	    events = {
	        @EventConfig(listeners = UIGalleryViewerConfig.SaveActionListener.class),
	        @EventConfig(listeners = UIGalleryViewerConfig.SelectFolderPathActionListener.class)
	    }
	)
	
public class UIGalleryViewerConfig extends UIForm implements UISelectable{

	/** The popup id. */
	private String popupId;
	  
	public UIGalleryViewerConfig() throws Exception {
		UIFormStringInput pathInput = new UIFormStringInput("path", "path", null);
		addUIFormInput(pathInput);
		
		PortletRequestContext portletRequestContext = WebuiRequestContext.getCurrentInstance();
        PortletPreferences preferences = portletRequestContext.getRequest().getPreferences();
        String galleryPath = preferences.getValue("galleryPath", "");   
        
        pathInput.setValue(galleryPath);
	}
	
	 /**
	   * Gets the popup id.
	   *
	   * @return the popup id
	   */
	  public String getPopupId() {
	    return popupId;
	  }

	  /**
	   * Sets the popup id.
	   *
	   * @param popupId the new popup id
	   */
	  public void setPopupId(String popupId) {
	    this.popupId = popupId;
	  }
	
	public static class SaveActionListener extends EventListener<UIGalleryViewerConfig> {
        public void execute(Event<UIGalleryViewerConfig> event) throws Exception {
        	UIGalleryViewerConfig basicConfig = event.getSource();
            UIFormStringInput gPathInput = basicConfig.getUIStringInput("path");                       
            
            PortletRequestContext portletRequestContext = WebuiRequestContext.getCurrentInstance();
            PortletPreferences preferences = portletRequestContext.getRequest().getPreferences();
            preferences.setValue("galleryPath", gPathInput.getValue());            
            preferences.store();      
        }
    }
    
    public static class SelectFolderPathActionListener extends EventListener<UIGalleryViewerConfig> {
        public void execute(Event<UIGalleryViewerConfig> event) throws Exception {        	
        	UIGalleryViewerConfig uiUpload = event.getSource();
            UIContentSelectorFolder contentSelector = uiUpload.createUIComponent(UIContentSelectorFolder.class,
                                                                               null,
                                                                               null);            
            contentSelector.init("collaboration", "/");
            contentSelector.getChild(UIContentBrowsePanelFolder.class)
                           .setSourceComponent(uiUpload,
                                               new String[] { "path" });
            Utils.createPopupWindow(uiUpload,
                                    contentSelector,
                                    UIContentSelector.CORRECT_CONTENT_SELECTOR_POPUP_WINDOW,
                                    800);
            UIGalleryViewerConfig uploadConfig = event.getSource();
            uploadConfig.setPopupId(UIContentSelector.CORRECT_CONTENT_SELECTOR_POPUP_WINDOW);
        }
    }
    
	@Override
	public void doSelect(String selectField, Object value) throws Exception {
		
		String[] params = value.toString().split(":");
		String path = "";
		if (params != null && params.length > 0) {
		  path = params[params.length - 1];
		  path = path.substring(1);
		}
		
		getUIStringInput(selectField).setValue(path);
		
		UIGalleryViewerPortlet categoryNavigationPortlet = getAncestorOfType(UIGalleryViewerPortlet.class);
	    UIPopupContainer popupContainer = categoryNavigationPortlet.getChild(UIPopupContainer.class);
	    Utils.closePopupWindow(popupContainer, this.popupId);
	}

}
