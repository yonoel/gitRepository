package com.igeek.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.igeek.service.IBaseService;
import com.igeek.service.ISubPaperService;
import com.igeek.service.ISubjectService;
import com.igeek.service.ITestpaperService;
import com.igeek.service.IUserService;

/**
 * @ClassName: BaseController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月10日 上午7:25:56
 * 
 */
public abstract class BaseController {
    @Autowired
    protected Map<String, IBaseService> map;
    
    //这样会注入所有实现了BaseService的Bean 但是顺序是不确定的 可以使用@Order或实现Ordered接口来实现
    @Autowired
    protected List<IBaseService> list;
    @Autowired
    protected ITestpaperService testpaperService;
    @Autowired
    protected ISubjectService subjectServices;
    @Autowired
    protected ISubPaperService subPaperServices;
    @Autowired
    protected com.igeek.service.IMastersService iMastersService;
    @Autowired
    protected IUserService userService;
}
