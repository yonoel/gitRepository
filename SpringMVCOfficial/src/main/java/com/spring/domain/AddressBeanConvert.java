package com.spring.domain;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

/**  
* @ClassName: AddressBeanConvert  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月12日 下午3:21:55    
*    
*/
public class AddressBeanConvert implements ConversionService{

    /**  
    * @Title: canConvert  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param sourceType
    * @param targetType
    * @return
    * @see org.springframework.core.convert.ConversionService#canConvert(java.lang.Class, java.lang.Class)
    */
    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        // TODO Auto-generated method stub
        return false;
    }

    /**  
    * @Title: canConvert  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param sourceType
    * @param targetType
    * @return
    * @see org.springframework.core.convert.ConversionService#canConvert(org.springframework.core.convert.TypeDescriptor, org.springframework.core.convert.TypeDescriptor)
    */
    @Override
    public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
        // TODO Auto-generated method stub
        return false;
    }

    /**  
    * @Title: convert  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param source
    * @param targetType
    * @return
    * @see org.springframework.core.convert.ConversionService#convert(java.lang.Object, java.lang.Class)
    */
    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        // TODO Auto-generated method stub
        return null;
    }

    /**  
    * @Title: convert  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param source
    * @param sourceType
    * @param targetType
    * @return
    * @see org.springframework.core.convert.ConversionService#convert(java.lang.Object, org.springframework.core.convert.TypeDescriptor, org.springframework.core.convert.TypeDescriptor)
    */
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        // TODO Auto-generated method stub
        return null;
    }

}
