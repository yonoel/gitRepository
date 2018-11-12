package com.igeek.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.igeek.DTO.TestpaperDTO;
import com.igeek.domain.Testpaper;
import com.igeek.mapper.SubPaperMapper;
import com.igeek.mapper.TestpaperMapper;
import com.igeek.service.ITestpaperService;

/**
 * @ClassName: TestpaperServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 下午8:50:43
 * 
 */
@Service
public class TestpaperServiceImpl extends BaseServices implements ITestpaperService {

    /**
     * @Title: pageQuery
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pagenum
     * @return
     * @see com.igeek.service.ITestpaperService#pageQuery(java.lang.Integer)
     */
    @Override
    public Map<String, Object> pageQuery(Integer pagenum) {
        TestpaperMapper mapper = sqlSession.getMapper(TestpaperMapper.class);
        Page<Object> pages = PageHelper.startPage(pagenum, 10).doSelectPage(() -> mapper.selectAll());
        LogicAssert(pages);
        return map;
    }

    /**
     * @Title: insert
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param dto
     * @return
     * @see com.igeek.service.ITestpaperService#insert(com.igeek.DTO.TestpaperDTO)
     */
    @Override
    public String insert(TestpaperDTO dto) {
        TestpaperMapper mapper = sqlSession.getMapper(TestpaperMapper.class);
        Testpaper testpaper = (Testpaper) Convert2BO(dto);
        int i = mapper.insert(testpaper);
        String message;
        message = i == 0 ? "试卷新增失败" : "试卷新增成功";
        return message;
    }

    /**
     * @Title: update
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param dto
     * @return
     * @see com.igeek.service.ITestpaperService#update(com.igeek.DTO.TestpaperDTO)
     */
    @Override
    public String update(TestpaperDTO dto) {
        TestpaperMapper mapper = sqlSession.getMapper(TestpaperMapper.class);
        Testpaper testpaper = (Testpaper) Convert2BO(dto);
        int i = mapper.updateByPrimaryKeySelective(testpaper);

        String message;
        message = i == 0 ? "试卷更新失败" : "试卷更新成功";
        return message;
    }

    /**
     * @Title: testpaperScore
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param testno
     * @return
     * @see com.igeek.service.ITestpaperService#testpaperScore(java.lang.String)
     */
    @Override
    public boolean testpaperScore(Integer testno) {
        TestpaperMapper mapper = sqlSession.getMapper(TestpaperMapper.class);
        return mapper.exsiteScore(testno);
    }

    /**
     * @Title: deletePapers
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param testnos
     * @return
     * @see com.igeek.service.ITestpaperService#deletePapers(java.util.List)
     */
    @Override
    public Map<String, Object> deletePapers(List<Integer> testnos) {
        Boolean flag = false;
        map.put("flag", flag);

        TestpaperMapper paper = sqlSession.getMapper(TestpaperMapper.class);

        int i = paper.deleteInList(testnos);
        if (i != testnos.size()) {
            // 回滚
            map.put("message", "试卷没有删除成功");
            return map;
        }
        // 除了要删testpaper表，还要删除subpaper表
        SubPaperMapper sub = sqlSession.getMapper(SubPaperMapper.class);

        int j = sub.deleteInList(testnos);
        // j必须与所有subpaper里的行数相匹配;
        if (j != sub.selectCountInList(testnos)) {
            // 回滚
            map.put("message", "试卷题目没有删除成功");
            return map;
        }

        flag = true;
        map.put("message", "删除成功");
        return map;
    }

    /**
     * @Title: setScore
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param integer
     * @return
     * @see com.igeek.service.ITestpaperService#setScore(java.lang.Integer)
     */
    @Override
    public Boolean setScore(Integer tesno) {
        TestpaperMapper paper = sqlSession.getMapper(TestpaperMapper.class);
        return paper.setScore(tesno);
    }

}
