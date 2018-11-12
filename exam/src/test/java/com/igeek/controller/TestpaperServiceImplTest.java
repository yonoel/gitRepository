package com.igeek.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igeek.DTO.SubjectDTO;
import com.igeek.config.AppConfig;
import com.igeek.serviceImpl.SubPaperServiceImpl;
import com.igeek.serviceImpl.SubjectServicesImpl;
import com.igeek.serviceImpl.TestpaperServiceImpl;

/**
 * @ClassName: TestpaperServiceImplTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月10日 上午7:46:47
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestpaperServiceImplTest {
//    @Autowired
//    private TestpaperServiceImpl paper;
    @Autowired
    private SubjectServicesImpl subject;
//    @Autowired
//    private SubPaperServiceImpl subPaperServiceImpl;

    @Test
    public void test() {
        // assertEquals(true, services.testpaperScore(1));
        // assertEquals(false, services.testpaperScore(3));
        // SubPaper subPaper = new SubPaper();
        // subPaper.setScore(10);
        // subPaper.setTestno(9);
        // subPaper.setSubno(1);
        // subPaperServiceImpl.changeScore(subPaper);
        SubjectDTO subjectDto = new SubjectDTO();
        subject.insert(subjectDto);
    }

}
