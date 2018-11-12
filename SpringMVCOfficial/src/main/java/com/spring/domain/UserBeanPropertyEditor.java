package com.spring.domain;

import java.beans.PropertyEditorSupport;

/**
 * @ClassName: UserBeanPeopertyEditor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月12日 上午10:15:17
 * 
 */
public class UserBeanPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setValue(Object value) {
        
        firePropertyChange();
    }
}
