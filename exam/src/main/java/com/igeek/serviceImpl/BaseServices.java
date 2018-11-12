package com.igeek.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.igeek.DTO.DTOConvert;
import com.igeek.DTO.SubjectDTO;
import com.igeek.DTO.TestpaperDTO;
import com.igeek.aop.MyException;
import com.igeek.domain.Subject;
import com.igeek.domain.Testpaper;
import com.igeek.service.ISubPaperService;
import com.igeek.service.ITestpaperService;

/**
 * @ClassName: BaseServices
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午6:53:20
 * 
 */
@Transactional(noRollbackFor = MyException.class, propagation = Propagation.REQUIRED)
public abstract  class BaseServices implements DTOConvert<Object, Object> {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 7196335894011020980L;
  
    @Autowired
    protected SqlSession sqlSession;
    @Autowired
    protected ISubPaperService subPaperService;
    @Autowired
    protected ITestpaperService testpaperService;

    public abstract Map<String, Object> pageQuery(Integer pagenum);

    protected Map<String, Object> map = new HashMap<String, Object>();

    /**
     * @Title: LogicAssert
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param pages
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected void LogicAssert(Object obj) {
        if (obj instanceof Page) {
            Page<Object> pages = (Page<Object>) obj;
            // 获取结果集
            List<Object> results = pages.getResult().stream().collect(Collectors.toList());

            if (results != null && !results.isEmpty()) {
                List dtos = null;
                if (results.get(0) instanceof Subject) {
                    dtos = new ArrayList<SubjectDTO>();
                    for (Object object : results) {
                        SubjectDTO dto = (SubjectDTO) Convert2DTO(object);
                        dto.setDiff();
                        dto.setType();
                        dtos.add(dto);
                    }

                } else if (results.get(0) instanceof Testpaper) {
                    dtos = new ArrayList<TestpaperDTO>();
                    for (Object object : results) {
                        TestpaperDTO dto = (TestpaperDTO) Convert2DTO(object);
                        dto.setDtoscore();
                        dtos.add(dto);
                    }

                }
                map.put("pages", dtos);
                map.put("flag", true);
                map.put("total", pages.getPages());
            } else {
                map.put("flag", false);
            }
        }

    }

    /**
     * @Title: Convert2DTO
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param s
     * @return
     * @see com.igeek.DTO.DTOConvert#Convert2DTO(java.lang.Object)
     */
    @Override
    public Object Convert2DTO(Object s) {
        Object object = null;
        if (s instanceof Subject) {
            object = new SubjectDTO();
            BeanUtils.copyProperties(s, object);
        } else if (s instanceof Testpaper) {
            object = new TestpaperDTO();
            BeanUtils.copyProperties(s, object);

        }

        return object;
    }

    /**
     * @Title: Convert2BO
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param t
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @see com.igeek.DTO.DTOConvert#Convert2BO(java.lang.Object)
     */
    @Override
    public Object Convert2BO(Object t) {
        Object subObject = null;
        try {
            Class<?> clasz = t.getClass().getSuperclass();
            subObject = clasz.newInstance();
            BeanUtils.copyProperties(t, subObject);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subObject;
    }

}
