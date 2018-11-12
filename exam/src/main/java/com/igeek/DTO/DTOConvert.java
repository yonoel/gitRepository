package com.igeek.DTO;

/**
 * @ClassName: DTOConvert
 * @Description: DTO的通用转换器接口
 * @date 2018年8月9日 上午7:29:37
 * 
 */
public interface DTOConvert<S, T> {
    T Convert2DTO (S s);

    S Convert2BO (T t);
}
