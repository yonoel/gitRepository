package com.igeek.web.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * @ClassName: UserDTO
 * @Description: 用于跨域传输的对象
 * @date 2018年7月25日 下午4:49:26
 * 
 */
public class UserDTO {
    private Map<String, Object> errors = new HashMap<String, Object>();
    // 与注册表单的form字段一模一样
    // <input type="text" name="username"/>
    private String username;
    // <input type="password" name="userPwd"/>
    private String password;
    // <input type="password" name="confirmPwd"/>
    private String confirmpwd;
    // <input type="text" name="email"/>
    private String telephone;

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String email;
    // <input type="text" name="birthday"/>
    private String birthday;
    private String name;
    private String sex;

    /*
     * validate方法负责校验表单输入项 表单输入项校验规则： private String userName 用户名不能为空，并且要是3-8的字母
     * abcdABcd private String userPwd 密码不能为空，并且要是3-8的数字 private String
     * confirmPwd 两次密码要一致 private String email 可以为空，不为空要是一个合法的邮箱 private String
     * birthday; 可以为空，不为空时，要是一个合法的日期
     */
    public boolean validate(String order) {

        boolean isOk = true;
        if (order.contains("login")) {
           
      
               
          

        } else if (order.contains("register")) {
            if (this.username == null || this.username.trim().equals("")) {
                isOk = false;
                errors.put("message", "用户名不能为空！！");
            } else {
                if (!this.username.matches("[a-zA-Z]{3,8}")) {
                    isOk = false;
                    errors.put("message", "用户名必须是3-8位的字母！！");
                }
            }

            if (this.password == null || this.username.trim().equals("")) {
                isOk = false;
                errors.put("message", "密码不能为空！！");
            } else {
                if (!this.password.matches("\\d{3,8}")) {
                    isOk = false;
                    errors.put("message", "密码必须是3-8位的数字！！");
                }

            }

            // private String password2; 两次密码要一致
            if (this.confirmpwd != null) {
                if (!this.confirmpwd.equals(this.password)) {
                    isOk = false;
                    errors.put("message", "两次密码不一致！！");
                }
            }

            // private String email; 可以为空，不为空要是一个合法的邮箱
            if (this.email != null && !this.email.trim().equals("")) {
                if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
                    isOk = false;
                    errors.put("message", "邮箱不是一个合法邮箱！！");
                }
            }

            // private String birthday; 可以为空，不为空时，要是一个合法的日期
            if (this.birthday != null && !this.birthday.trim().equals("")) {
                try {
                    DateLocaleConverter conver = new DateLocaleConverter();
                    conver.convert(this.birthday);
                } catch (Exception e) {
                    isOk = false;
                    errors.put("message", "生日必须要是一个日期！！");
                }
            }
        }

        errors.put("flag", isOk);
        return isOk;
    }

    /**
     * @return the errors
     */
    public Map<String, Object> getErrors() {
        return errors;
    }

    /**
     * @param errors
     *            the errors to set
     */
    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmpwd
     */
    public String getConfirmpwd() {
        return confirmpwd;
    }

    /**
     * @param confirmpwd
     *            the confirmpwd to set
     */
    public void setConfirmpwd(String confirmpwd) {
        this.confirmpwd = confirmpwd;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

}
