package com.igeek.service;

import java.util.List;
import java.util.Map;

import com.igeek.domain.SubPaper;

/**
 * @ClassName: ISubPaperService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月10日 上午7:24:27
 * 
 */
public interface ISubPaperService extends IBaseService{

    /**
     * @param newsub
     * @Title: insertMany
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param score
     * @param testno
     * @return 
     */
    Map<String, Object> insertMany(List<Integer> newsub, Integer score, Integer testno);

    /**  
    * @Title: findPaperInfo  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param testno
    * @return    
    */
    Map<String, Object> findPaperInfo(Integer testno);

    
    /**  
    * @Title: deleteSubpaper  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subPaper
    * @return    
    */
    Map<String, Object> deleteSubpaper(SubPaper subPaper);

    /**  
    * @Title: changeScore  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param subPaper
    * @return    
    */
    Map<String, Object> changeScore(SubPaper subPaper);

}
