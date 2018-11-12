package com.mybatisMapper4.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @ClassName: Area  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月8日 下午3:56:50    
*    
*/
@Table
public class Area {
    /**  
    * @Title: toString  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "Area [id=" + id + ", areaname=" + areaname + "]";
    }
    @Id
    private String id;
    @Column(name="areaname")
    private String areaname;
}
