package com.mybatisMapper4.domain;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @ClassName: Province  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月8日 下午3:56:24    
*    
*/
@Table(name="province")
public class Province {
    @Id
    private String code;
    /**  
    * @Title: toString  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "Province [code=" + code + ", name=" + name + ", cities=" + cities + "]";
    }
    private String name;
    private List<City> cities;
}
