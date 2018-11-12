package com.igeek.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.igeek.DTO.SubjectDTO;
import com.igeek.DTO.TestpaperDTO;
import com.igeek.domain.Subject;
import com.igeek.mapper.SubjectMapper;
import com.igeek.service.ISubjectService;

/**
 * @ClassName: SubjectServicesImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午6:52:53
 * 
 */
@Service
public class SubjectServicesImpl extends BaseServices implements ISubjectService {
    /**  
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
    */  
    private static final long serialVersionUID = -2608380281540150337L;

   
    public void testMethod() {

        // SubPaperMapper mapper = sqlSession.getMapper(SubPaperMapper.class);

        /* mapper.selectSubjectDTOByTestno(1).forEach(System.out::println); */
        /*
         * List<Integer> testnos = Arrays.asList(3);
         * System.out.println(mapper.selectCountInList(testnos));
         */
        /*
         * SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
         * List<Integer> list = mapper.selectSubnoByTypeAndDiff(1, 1);
         * list.forEach(System.out::println);
         */
    }

    /**
     * @Title: pageQuery
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pagenum
     * @return
     * @see com.igeek.service.ISubjectService#pageQuery(java.lang.Integer)
     */
    @Override
    public Map<String, Object> pageQuery(Integer pagenum) {

        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        Page<Object> pages = PageHelper.startPage(pagenum, 10).doSelectPage(() -> mapper.selectAll());

        LogicAssert(pages);
        return map;
    }

    /**
     * @Title: querySubjects
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subjectDTO
     * @return
     * @see com.igeek.service.ISubjectService#querySubjects(com.igeek.DTO.SubjectDTO)
     */
    @Override
    public Map<String, Object> querySubjects(SubjectDTO subjectDTO) {
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        Subject subject = (Subject) Convert2BO(subjectDTO);
        Page<Object> pages = PageHelper.startPage(1, 10).doSelectPage(() -> mapper.select(subject));
        LogicAssert(pages);
        return map;
    }

    /**
     * @Title: insert
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subjectDto
     * @return
     * @see com.igeek.service.ISubjectService#insert(com.igeek.DTO.SubjectDTO)
     */
    @Override
    public String insert(SubjectDTO subjectDto) {
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        Subject subject = (Subject) Convert2BO(subjectDto);
        int i = mapper.insert(subject);
        String message = i == 0 ? "新增失败" : "新增成功";
        throw new RuntimeException();
    }

    /**
     * @Title: update
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subjectDto
     * @return
     * @see com.igeek.service.ISubjectService#update(com.igeek.DTO.SubjectDTO)
     */
    @Override
    public String update(SubjectDTO subjectDto) {
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        Subject subject = (Subject) Convert2BO(subjectDto);
        int i = mapper.updateByPrimaryKey(subject);
        String message = i == 0 ? "更新失败" : "更新成功";
        return message;
    }

    /**
     * @Title: delete
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subNo
     * @return
     * @see com.igeek.service.ISubjectService#delete(java.lang.String[])
     */
    @Override
    public String delete(String[] subNo) {
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);

        int count = 0;
        for (int i = 0; i < subNo.length; i++) {
            count += mapper.deleteByPrimaryKey(subNo[i]);
        }
        return count == subNo.length ? "删除成功" : "删除失败";
    }

    public String deleteInlist(String[] subnos) {
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);

        int i = mapper.deleteInlist(subnos);
        String message;
        if (i != subnos.length) {
            message = "删除失败";
        } else {
            message = "删除成功";
        }
        return message;
    }

    /**
     * @Title: sub2PaperHandler
     * @Description: 当paper米有分值时允许智能出卷
     * @param subjectDTO
     * @return
     * @see com.igeek.service.ISubjectService#sub2PaperHandler(java.util.List)
     */
    @Override
    public Map<String, Object> sub2PaperHandler(List<SubjectDTO> subjectDTO, Integer testno) {
        SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
        // 获取总分
        Integer sum = 0;
        // 对每种题型进行检索，返回全部
        for (SubjectDTO dto : subjectDTO) {
            // 获取这个题型的总分
            sum += dto.getSubjectnum() * dto.getScore();

            Subject subject = (Subject) Convert2BO(dto);

            // 返回这个题型的所有ID
            List<Integer> newsub = mapper.selectSubnoByTypeAndDiff(subject.getSubType(), subject.getDifficulty());
            // 数据库题目不够
            if (newsub.size() < dto.getSubjectnum()) {
                map.put("flag", false);
                map.put("message", dto.getType() + "数量不足，无法出卷");
                return map;
            } else {
                // 数量足够，随机出题-->交给subpaper的接口(需要试卷编号，分值，题目编号)
                // 获取题目编号的数组--->随机抽取数量(因为我是并发。。已经算是随机了吧)
                newsub = newsub.parallelStream().limit(dto.getSubjectnum()).collect(Collectors.toList());
                map = subPaperService.insertMany(newsub, dto.getScore(), testno);
                // 每一种题型都要进行判断是否完全增加成功
                if (!(boolean) map.get("flag")) {
                    map.put("message", dto.getDiff() + "的" + dto.getType() + "出题失败");
                    return map;
                }
                // 为真继续循环
            }
        }
        // 题目出完以后，更新paper

        TestpaperDTO dto = new TestpaperDTO();
        dto.setTestno(testno);
        dto.setScore(sum);

        // 更新这里可能出异常，抛给了这一层
        String message = testpaperService.update(dto);
        map.put("message", message);

        // 如果失败，标记
        if ("试卷更新失败".equals(message)) {
            map.put("flag", false);
            // -->需要回滚
            return map;
        }
        // 所有数据都为true
        map.put("flag", true);
        map.put("message", "出卷成功");
        return map;
    }

}
