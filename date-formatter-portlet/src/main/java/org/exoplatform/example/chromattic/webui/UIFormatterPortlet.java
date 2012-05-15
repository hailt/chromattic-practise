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
public class UIFormatterPortlet extends UIPortletApplication {
 
    public static final String TEXT_PREFERENCE = "text";
 
    public UIFormatterPortlet() throws Exception {
        super();
        addChild(UIPopupContainer.class, null, null);
    }
 
    public void processRender(WebuiApplication app, WebuiRequestContext context) throws Exception {
        PortletRequestContext pContext = (PortletRequestContext) context ;
        PortletMode currentMode = pContext.getApplicationMode() ;
        if(PortletMode.VIEW.equals(currentMode)) {
            if (getChild(UIFormatterForm.class) == null) addChild(UIFormatterForm.class, null, null);
        } else {
        	removeChild(UIFormatterForm.class);
        }
                
        super.processRender(app, context) ;
    }
 
}