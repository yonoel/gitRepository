package com.mybatisMapper4.domain;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @ClassName: City  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月8日 下午3:56:34    
*    
*/
@Table
public class City {
    /**  
    * @Title: toString  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "City [code=" + code + ", name=" + name + ", district=" + district + "]";
    }
    @Id
    private String code;
    private String name;
    private List<Area> district;
}
