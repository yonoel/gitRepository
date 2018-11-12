package com.igeek.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import com.igeek.DTO.SubjectDTO;
import com.igeek.domain.SubPaper;
import com.igeek.mapper.SubPaperMapper;
import com.igeek.service.ISubPaperService;

import tk.mybatis.mapper.entity.Example;

/**
 * @ClassName: SubPaperServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月10日 上午7:24:55
 * 
 */
@Service
public class SubPaperServiceImpl extends BaseServices implements ISubPaperService {

    /**
     * @Title: insertMany
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subjectDTO
     * @param testno
     * @return
     * @see com.igeek.service.ISubPaperService#insertMany(java.util.List,
     *      java.lang.Integer)
     */
    @Override
    @Transient
    public Map<String, Object> insertMany(List<Integer> newsub, Integer score, Integer testno) {
        SubPaperMapper mapper = sqlSession.getMapper(SubPaperMapper.class);
        for (Integer no : newsub) {
            SubPaper subPaper = new SubPaper(no, testno, score);
            Integer flag = mapper.insert(subPaper);
            if (flag != 1) {
                map.put("flag", false);
                // 回滚
                return map;
            }
        }
        map.put("flag", true);
        return map;
    }

    /**
     * @Title: findPaperInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param testno
     * @return
     * @see com.igeek.service.ISubPaperService#findPaperInfo(java.lang.Integer)
     */
    @Override
    public Map<String, Object> findPaperInfo(Integer testno) {
        // 1.根据testno查询，获取 subno和score,2.根据subno查询subject表,获取subject对象
        // 3,根据subject对象类型分组

        // // 1.根据testno查询，获取 subno和score
        // SubPaperMapper subPaperMapper =
        // sqlSession.getMapper(SubPaperMapper.class);
        // SubPaper record = new SubPaper();
        // record.setTestno(testno);
        // List<SubPaper> subPapers = subPaperMapper.select(record);
        //
        // // 2.根据subno查询subject表,获取subject对象
        // int[] subnos = subPapers.parallelStream().mapToInt(sp ->
        // sp.getSubno()).toArray();
        // SubjectMapper subjectMapper =
        // sqlSession.getMapper(SubjectMapper.class);
        // List<Subject> subjects = subjectMapper.selectByPrimaryKeys(subnos);
        // // 3,根据subject对象类型分组(可以在分组前，先转出DTO) 仅根据subject分组，没有获取每题的分值
        // List<SubjectDTO> subjectDTOs =
        // subjects.parallelStream().collect(ArrayList<SubjectDTO>::new, (list,
        // item) -> {
        // SubjectDTO dto = subject2Dto(item);
        // list.add(dto);
        // }, ArrayList<SubjectDTO>::addAll);

        // 太浪费时间了，干脆sql文内连接查询
        SubPaperMapper subPaperMapper = sqlSession.getMapper(SubPaperMapper.class);
        List<SubjectDTO> subjectDTOs = subPaperMapper.selectSubjectDTOByTestno(testno);
        // 设置人可读的type;
        subjectDTOs.forEach(SubjectDTO::setType);
        // 根据subtype分组 先看看有几个组
        Object[] types = subjectDTOs.parallelStream().map(SubjectDTO::getSubType).distinct().toArray();
        // 根据不同types获取不同的subjectdto集合
        for (int i = 0; i < types.length; i++) {
            String t = (String) types[i];
            // 求得总分
            int sum = subjectDTOs.parallelStream().filter(s -> t.equals(s.getSubType())).mapToInt(SubjectDTO::getScore)
                    .sum();

            Map<String, List<Object>> subjects = subjectDTOs.stream().filter(s -> t.equals(s.getSubType()))
                    .collect(Collectors.groupingBy(SubjectDTO::getType, Collectors.toList()));
            subjects.forEach((k, v) -> v.add(sum));

            // 把它放入容器
            map.putAll(subjects);

        }
        return map;
    }

    /**
     * @Title: deleteSubpaper
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subPaper
     * @return
     * @see com.igeek.service.ISubPaperService#deleteSubpaper(com.igeek.domain.SubPaper)
     */
    @Override
    @Transient
    public Map<String, Object> deleteSubpaper(SubPaper subPaper) {
        SubPaperMapper subPaperMapper = sqlSession.getMapper(SubPaperMapper.class);
        int i = subPaperMapper.delete(subPaper);
        String message;
        if (i == 0) {
            message = "删除失败";
            map.put("flag", false);
            map.put("message", message);
        } else {
            // 这个本来要在update以后才能判定，但是由于，我只想返回一次map，所以先判定真
            message = "删除成功";
            map.put("flag", true);
            map.put("message", message);
            // 注意这里要改变testpaper表里的分值
            if (testpaperService.setScore(subPaper.getTestno())) {
                // 回滚
                message = "删除失败";
                map.put("flag", false);
                map.put("message", message);
            }
            
        }
        return map;
    }

    /**
     * @Title: changeScore
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subPaper
     * @return
     * @see com.igeek.service.ISubPaperService#changeScore(com.igeek.domain.SubPaper)
     */
    @Override
    @Transient
    public Map<String, Object> changeScore(SubPaper subPaper) {
        SubPaperMapper subPaperMapper = sqlSession.getMapper(SubPaperMapper.class);
        int score = subPaper.getScore();
        subPaper.setScore(null);
        Example example = new Example(SubPaper.class);
        // 这个条件必须要以非空字段匹配
        example.createCriteria().andEqualTo(subPaper);
        subPaper.setScore(score);
        int i = subPaperMapper.updateByExample(subPaper, example);
        String message;
        if (i == 0) {
            message = "更改分值失败";
            map.put("flag", false);
            map.put("message", message);
        } else {
            // 这个本来要在update以后才能判定，但是由于，我只想返回一次map，所以先判定真
            message = "更改分值成功";
            map.put("flag", true);
            map.put("message", message);
            // 注意这里要改变testpaper表里的分值(简单点么。。就直接根据分值修改 -->不行，还是要获取之前的分值)
            if (testpaperService.setScore(subPaper.getTestno())) {
                // 回滚
                message = "更改分值失败";
                map.put("flag", false);
                map.put("message", message);
            }
        }
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
