package com.igeek.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.igeek.domain.Master;
import com.igeek.mapper.MasterMapper;
import com.igeek.service.IMastersService;

/**  
* @ClassName: MasterServicesImpl  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 下午6:56:21    
*    
*/
@Service
public class MasterServicesImpl extends BaseServices implements IMastersService{

    /**  
    * @Title: queryDiffAndType  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see com.igeek.service.IMastersService#queryDiffAndType()
    */
    @Override
    public Map<String, Object> queryDiffAndType() {
        MasterMapper mapper = sqlSession.getMapper(MasterMapper.class);
        List<Master> masters =mapper.selectAll();
        List<Master> typeList = masters.stream().filter(p->"sub_type".equalsIgnoreCase(p.getKeyName())).collect(Collectors.toList());
        List<Master> diffList = masters.stream().filter(p->"task_diff".equalsIgnoreCase(p.getKeyName())).collect(Collectors.toList());
        map.put("typeList", typeList);
        map.put("diffList", diffList);
        return map;
    }

    /**  
    * @Title: pageQuery  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param pagenum
    * @return
    * @see com.igeek.serviceImpl.BaseServices#pageQuery(java.lang.Integer)
    */
    @Override
    public Map<String, Object> pageQuery(Integer pagenum) {
        // TODO Auto-generated method stub
        return null;
    }

}
