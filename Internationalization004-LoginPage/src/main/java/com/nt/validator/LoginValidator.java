package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.LoginForm;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		LoginForm form = (LoginForm) target;

		if (form.getUsername() == null || form.getUsername().trim().isEmpty()) {
			errors.rejectValue("username", "validation.username.required");
		}

		if (form.getPassword() == null || form.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "validation.password.required");
		}
	}
}