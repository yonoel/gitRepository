package com.igeek.service;

import java.util.Map;

/**  
* @ClassName: MasterMapper  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 下午6:36:00    
*    
*/
public interface IMastersService extends IBaseService{

    /**  
    * @return 
     * @Title: queryDiffAndType  
    * @Description: TODO(这里用一句话描述这个方法的作用)      
    */
    Map<String, Object> queryDiffAndType();

}
