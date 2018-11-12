package com.igeek.service;

import java.util.List;
import java.util.Map;

import com.igeek.DTO.TestpaperDTO;

/**  
* @ClassName: ITestpaperService  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月8日 下午8:50:00    
*    
*/
public interface ITestpaperService extends IBaseService{

    /**  
    * @Title: pageQuery  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pagenum
    * @return    
    */
    Map<String, Object> pageQuery(Integer pagenum);

    /**  
    * @Title: insert  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param dto
    * @return    
    */
    String insert(TestpaperDTO dto);

    /**  
    * @Title: update  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param dto
    * @return    
    */
    String update(TestpaperDTO dto);

    /**  
    * @Title: testpaperScore  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param testno
    * @return    
    */
    boolean testpaperScore(Integer testno);

    /**  
    * @Title: deletePapers  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param testnos    
    */
    Map<String, Object> deletePapers(List<Integer> testnos);

    /**  
    * @param integer 
     * @Title: setScore  
    * @Description: TODO(这里用一句话描述这个方法的作用)      
    */
    Boolean setScore(Integer integer);



}
