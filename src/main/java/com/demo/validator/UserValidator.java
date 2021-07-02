package com.demo.validator;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.entities.User;
import com.demo.service.IUserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private IUserService userService;

    public boolean supports(Class<?> aClass ) {
        return UserValidator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) 
    {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        
        if (user.getUserName().length() < 6 || user.getUserName().length()>32)
        {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUserName(user.getUserName()) != null) 
        {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) 
        {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPassword().equals(user.getPassword())) 
        {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

	
}


*/