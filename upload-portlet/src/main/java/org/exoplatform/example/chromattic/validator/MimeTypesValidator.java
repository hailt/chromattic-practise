package org.exoplatform.example.chromattic.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.exoplatform.upload.UploadResource;
import org.exoplatform.web.application.ApplicationMessage;
import org.exoplatform.webui.exception.MessageException;
import org.exoplatform.webui.form.UIFormInput;
import org.exoplatform.webui.form.UIFormUploadInput;
import org.exoplatform.webui.form.validator.Validator;

public class MimeTypesValidator implements Validator {

	private String mimeTypes_;

	public MimeTypesValidator() {
	}

	public MimeTypesValidator(String mimeTypes) {
		this.mimeTypes_ = mimeTypes;
	}

	public void validate(UIFormInput uiInput) throws Exception {
		if (uiInput instanceof UIFormUploadInput) {
			UIFormUploadInput uploadInput = UIFormUploadInput.class.cast(uiInput);
			
			UploadResource uploadResource = uploadInput.getUploadResource();
        	String mimeTypeInput = uploadResource == null ? null : uploadResource.getMimeType();
        	
        	if (mimeTypes_ != null && mimeTypeInput != null) {
				Pattern pattern = Pattern.compile(mimeTypes_.replace("*", ".*"));
				Matcher matcher = pattern.matcher(mimeTypeInput);
				if (!matcher.find()) {
					Object[] args = { mimeTypeInput, uploadInput.getName() };
					throw new MessageException(new ApplicationMessage("UploadFileMimeTypesValidator.msg.wrong-mimetype", args, ApplicationMessage.WARNING));
				}
			}
		}
	}
}
