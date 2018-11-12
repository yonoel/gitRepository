package com.spring.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ClassName: UserValidator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午12:01:03
 * 
 */

public class UserValidator implements Validator {

    /**
     * @Title: supports
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param clazz
     * @return
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> candidate) {
        // TODO Auto-generated method stub
        return User.class.isAssignableFrom(candidate);
    }

    /**
     * @Title: validate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param target
     * @param errors
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     *      org.springframework.validation.Errors)
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Field is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "psd", "required", "Field is required");
    }

}
