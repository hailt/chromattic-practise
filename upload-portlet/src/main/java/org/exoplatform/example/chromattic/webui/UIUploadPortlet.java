package org.exoplatform.example.chromattic.webui;

import javax.portlet.PortletMode;

import org.exoplatform.webui.application.WebuiApplication;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.UIPopupContainer;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
 
@ComponentConfig(
    lifecycle = UIApplicationLifecycle.class
)
public class UIUploadPortlet extends UIPortletApplication {
 
    public static final String TEXT_PREFERENCE = "text";
 
    public UIUploadPortlet() throws Exception {
        super();
        addChild(UIPopupContainer.class, null, null);
    }
 
    public void processRender(WebuiApplication app, WebuiRequestContext context) throws Exception {
        PortletRequestContext pContext = (PortletRequestContext) context ;
        PortletMode currentMode = pContext.getApplicationMode() ;
        if(PortletMode.VIEW.equals(currentMode)) {
        	removeChild(UIUploadConfig.class);
            if (getChild(UIUploadForm.class) == null) addChild(UIUploadForm.class, null, null);
        } else {
        	removeChild(UIUploadForm.class);
            if (getChild(UIUploadConfig.class) == null) addChild(UIUploadConfig.class, null, null);
        }
        
        super.processRender(app, context) ;
    }
 
}