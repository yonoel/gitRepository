package com.igeek.mvc.convert;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
* @ClassName: MaskNumberFormater  
* @Description: 一个用于声明数字模糊化的注解
* @date 2018年8月3日 上午8:47:26    
*    
*/
@Target(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MaskNumberFormat {
    String value();
}
