package com.igeek.service;

import com.igeek.domain.User;

/**  
* @ClassName: UserMapper  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 下午6:36:26    
*    
*/
public interface IUserService extends IBaseService{

    /**  
    * @Title: query  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param user
    * @return    
    */
    boolean query(User user);

    /**  
    * @Title: getUserByNameAndPassword  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param user    
    */
    User getUserByNameAndPassword(User user);

}
