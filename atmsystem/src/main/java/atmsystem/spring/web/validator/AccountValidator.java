package atmsystem.spring.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @ClassName: AccountValidator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午5:58:58
 * 
 */
public class AccountValidator implements Validator {

    /**
     * @Title: supports
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param clazz
     * @return
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return false;
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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "姓名不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "密码不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "draw", "required", "取款金额不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "save", "required", "存款金额不能为空");

    }

}
