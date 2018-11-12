package com.igeek.domain;

/**
 * @ClassName: SexEnum
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月16日 下午4:32:49
 * 
 */
public enum SexEnum {
    FEMALE(0, "女"), MALE(1, "男"),;

    /**
     * @Fields sexCode : TODO(用一句话描述这个变量表示什么)
     */
    private int sexCode;
    /**
     * @Fields sex : TODO(用一句话描述这个变量表示什么)
     */
    private String sex;

    // 注意构造方法是没有方法名的，直接返回对象
    /**
     * @Title: SexEnum
     * @param sexCode
     * @param sex
     */
    private SexEnum(int sexCode, String sex) {
        this.sexCode = sexCode;
        this.sex = sex;
    }

    /**
     * @return the sexCode
     */
    public int getSexCode() {
        return sexCode;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    // 通过Code的值来获取枚举类型，数据库只需保存code，通过代码解析成类型
    /**
     * @Title: getSexFromCode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param code
     * @return
     */
    public static SexEnum getSexFromCode(int code) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getSexCode() == code) {
                return sex;
            }
        }
        return null;
    }

    public static SexEnum getSexFromString(String sexName) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getSex().equals(sexName)) {
                return sex;
            }
        }
        return null;
    }
}
