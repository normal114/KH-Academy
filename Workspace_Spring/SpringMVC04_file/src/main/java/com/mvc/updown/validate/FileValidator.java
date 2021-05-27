package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// validator 사용 가능 여부 확인
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UploadFile file = (UploadFile) target;

		if (file.getMpfile().getSize() == 0) { // size가 0이면 에러. 파일을 선택해달라.
			// mpfile(field)에 대한 errorCode return, 
			// 만약 해당 errorCode가 없으면 default message 전달
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
			// fileNPE는 임의로 만든 파일. properties랑 관련 있는데 지금 안 만들어 놓아서 Please select a file이 뜬다.
		}
	}

}
