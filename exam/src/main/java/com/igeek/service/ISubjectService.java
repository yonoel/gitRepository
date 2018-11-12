package com.igeek.service;

import java.util.List;
import java.util.Map;

import com.igeek.DTO.SubjectDTO;

/**  
* @ClassName: SubjectMapper  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 下午6:35:09    
*    
*/
public interface ISubjectService extends IBaseService{

    /**  
    * @Title: pageQuery  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pagenum
    * @return    
    */
    Map<String, Object> pageQuery(Integer pagenum);

    /**  
    * @Title: querySubjects  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subjectDTO
    * @return    
    */
    Map<String, Object> querySubjects(SubjectDTO subjectDTO);

    /**  
    * @Title: insert  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subjectDto    
    */
    String insert(SubjectDTO subjectDto);

    /**  
    * @Title: update  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subjectDto
    * @return    
    */
    String update(SubjectDTO subjectDto);

    /**  
    * @Title: delete  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subNo
    * @return    
    */
    String delete(String[] subNo);


    /**  
    * @Title: sub2PaperHandler  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subjectDTO
     * @param testno 
    * @return    
    */
    Map<String, Object> sub2PaperHandler(List<SubjectDTO> subjectDTO, Integer testno);

}
