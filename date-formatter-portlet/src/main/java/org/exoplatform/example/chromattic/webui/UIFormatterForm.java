package org.exoplatform.example.chromattic.webui;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionResponse;
import javax.xml.namespace.QName;

import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.core.model.SelectItemOption;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIForm;
import org.exoplatform.webui.form.UIFormSelectBox;

@ComponentConfig(
		lifecycle = UIFormLifecycle.class, 
		events = {
                   @EventConfig(listeners = UIFormatterForm.ChangeFormatActionListener.class)
		}
)
public class UIFormatterForm extends UIForm {

	public UIFormatterForm() throws Exception {
		List<SelectItemOption<String>> options = new ArrayList<SelectItemOption<String>>();
		options.add(new SelectItemOption<String>("dd-MM-yyyy"));
		options.add(new SelectItemOption<String>("dd/MM/yyyy"));
		options.add(new SelectItemOption<String>("dd.MM.yyyy"));
		options.add(new SelectItemOption<String>("dd MM yyyy"));
		options.add(new SelectItemOption<String>("MM-yyyy"));
		options.add(new SelectItemOption<String>("MM-dd-yyyy"));
		options.add(new SelectItemOption<String>("MM/dd/yyyy"));
		options.add(new SelectItemOption<String>("MM.dd.yyyy"));
		options.add(new SelectItemOption<String>("MM dd yyyy"));
		UIFormSelectBox selectBox = new UIFormSelectBox("dateFormat", "dateFormat", options);
		selectBox.setOnChange("ChangeFormat");
		addUIFormInput(selectBox);
		
	}

	static public class ChangeFormatActionListener extends EventListener<UIFormatterForm> {
		public void execute(Event<UIFormatterForm> event) throws Exception {
			UIFormatterForm uiForm = event.getSource();
			UIFormSelectBox selectBox = (UIFormSelectBox)uiForm.getUIInput("dateFormat");
			
			ActionResponse actResponse = event.getRequestContext().getResponse();
	        actResponse.setEvent(new QName("ChangeFormat"), selectBox.getSelectedValues()[0]);			
		}
	}
}
