package com.spring.exception;

/**
 * @ClassName: SpringException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月9日 上午11:40:07
 * 
 */
public class SpringException extends RuntimeException {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 8871824529708714026L;
    private String exceptionMsg;

    public SpringException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
