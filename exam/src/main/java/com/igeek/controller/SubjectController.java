package com.igeek.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igeek.DTO.SubjectDTO;

/**
 * @ClassName: ExamController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月6日 下午7:10:14
 * 
 */
@RestController
@RequestMapping("/subject/")
public class SubjectController extends BaseController {

    @GetMapping("/pagequery")
    public Map<String, Object> pageQueryHandler(Integer pagenum) {
        return subjectServices.pageQuery(pagenum);
    }

    @GetMapping("/querylist")
    public Map<String, Object> querySubjectsHandler(SubjectDTO subjectDTO) {
        return subjectServices.querySubjects(subjectDTO);
    }

    @GetMapping("/subjecthandler")
    public String subjectHandler(SubjectDTO subjectDto, String methodflag) {
        if ("add".equals(methodflag)) {
            return subjectServices.insert(subjectDto);
        } else if ("mod".equals(methodflag)) {
            return subjectServices.update(subjectDto);
        }
        return "没有命令";
    }

    @GetMapping("/deletesubject")
    public String deleteHandler(@RequestParam("subNo") String[] subNo) {
        return subjectServices.delete(subNo);

    }
}
