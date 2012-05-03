package org.exoplatform.example.chromattic.webui;

import javax.portlet.EventRequest;
import javax.portlet.PortletMode;

import org.exoplatform.webui.application.WebuiApplication;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIPopupContainer;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
 
@ComponentConfig(
    lifecycle = UIApplicationLifecycle.class, 
    events = {
    	   @EventConfig(listeners = UIGalleryViewerPortlet.NewPhotoUploadedActionListener.class),
    	   @EventConfig(listeners = UIGalleryViewerPortlet.ChangeFormatActionListener.class)
    }
)
public class UIGalleryViewerPortlet extends UIPortletApplication {
 
    public static final String TEXT_PREFERENCE = "text";
    
    private String dateTimeFormat = "dd-MM-yyyy";
      
 	public UIGalleryViewerPortlet() throws Exception {
        super();
        addChild(UIPopupContainer.class, null, null);
    }
 	
 	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

 
    public void processRender(WebuiApplication app, WebuiRequestContext context) throws Exception {
        PortletRequestContext pContext = (PortletRequestContext) context ;
        PortletMode currentMode = pContext.getApplicationMode() ;
        if(PortletMode.VIEW.equals(currentMode)) {
        	removeChild(UIGalleryViewerConfig.class);
            if (getChild(UIGalleryViewerContainer.class) == null) addChild(UIGalleryViewerContainer.class, null, null);
        } else {
        	removeChild(UIGalleryViewerContainer.class);
            if (getChild(UIGalleryViewerConfig.class) == null) addChild(UIGalleryViewerConfig.class, null, null);
        }
        
        super.processRender(app, context) ;
    }
    
    static public class NewPhotoUploadedActionListener extends EventListener<UIGalleryViewerPortlet>
    {
       public void execute(Event<UIGalleryViewerPortlet> event) throws Exception
       {
          //do nothing
       }
    }
    
    static public class ChangeFormatActionListener extends EventListener<UIGalleryViewerPortlet>
    {
       public void execute(Event<UIGalleryViewerPortlet> event) throws Exception
       {
    	  String newFormat = ((EventRequest)event.getRequestContext().getRequest()).getEvent().getValue().toString();
          event.getSource().setDateTimeFormat(newFormat);
       }
    }
 
}
