package com.igeek.mvc.convert;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

/**  
* @ClassName: MaskNumberFormatImpl  
* @Description: 为MaskNumberFormat这个注解实现具体功能的类
* @date 2018年8月3日 上午8:49:49    
*    
*/
public class MaskNumberFormatImpl implements AnnotationFormatterFactory<MaskNumberFormat>{

    /**  
    * @Title: getFieldTypes  
    * @Description: 得到字段的数据类型。。
    * @return
    * @see org.springframework.format.AnnotationFormatterFactory#getFieldTypes()
    */
    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> fieldTypes = new HashSet<Class<?>>(1, 1);
        fieldTypes.add(String.class);
        return fieldTypes;
    }

    /**  
    * @Title: getPrinter  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param annotation
    * @param fieldType
    * @return
    * @see org.springframework.format.AnnotationFormatterFactory#getPrinter(java.lang.annotation.Annotation, java.lang.Class)
    */
    @Override
    public Printer<?> getPrinter(MaskNumberFormat annotation, Class<?> fieldType) {
        return new MaskFormatter(annotation.value());
    }

    /**  
    * @Title: getParser  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param annotation
    * @param fieldType
    * @return
    * @see org.springframework.format.AnnotationFormatterFactory#getParser(java.lang.annotation.Annotation, java.lang.Class)
    */
    @Override
    public Parser<?> getParser(MaskNumberFormat annotation, Class<?> fieldType) {
        return new MaskFormatter(annotation.value());
    }
     // 一个内部类MaskFormatter实现了formater这个接口，而formater又是Parser Printer的子接口
    private static class MaskFormatter implements Formatter<String> {

        private javax.swing.text.MaskFormatter delegate;
        // 通过这个构造函数，给他注入注解获取的字段值，交给javax.swing.text.MaskFormatter去处理
        public MaskFormatter(String mask) {
            try {
                this.delegate = new javax.swing.text.MaskFormatter(mask);
                this.delegate.setValueContainsLiteralCharacters(false);
            } catch (ParseException e) {
                throw new IllegalStateException("Mask could not be parsed " + mask, e);
            }
        }

        public String print(String object, Locale locale) {
            try {
                return delegate.valueToString(object);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Unable to print using mask " + delegate.getMask(), e);
            }
        }

        public String parse(String text, Locale locale) throws ParseException {
            return (String) delegate.stringToValue(text);
        }

    }

}
