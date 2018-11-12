package com.igeek.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igeek.DTO.SubjectDTO;
import com.igeek.DTO.TestpaperDTO;
import com.igeek.domain.SubPaper;

/**
 * @ClassName: TestpaperController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 下午8:47:46
 * 
 */
@RestController
@RequestMapping("/paper/")
public class TestpaperController extends BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @GetMapping("/pagequery")
    public Map<String, Object> pageQueryHandler(Integer pagenum) {
        return testpaperService.pageQuery(pagenum);
    }

    @GetMapping("/paperhandler")
    public String paperHandler(String methodflag, TestpaperDTO dto) {
        if ("add".equals(methodflag)) {
            return testpaperService.insert(dto);
        } else if ("mod".equals(methodflag)) {
            return testpaperService.update(dto);
        }
        return "没有命令";
    }

    @PostMapping("/sub2paper/{testno}")
    public Map<String, Object> sub2Paper(@RequestBody List<SubjectDTO> subjectDTO,
            @PathVariable("testno") Integer testno) {
        if (!testpaperService.testpaperScore(testno)) {
            return subjectServices.sub2PaperHandler(subjectDTO, testno);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", false);
        map.put("message", "本试卷已经有题目了，请修改试卷");
        return map;
    }

    @PostMapping("/deletepapers")
    public Map<String, Object> deletePapers(@RequestBody List<Integer> testnos) {
        return testpaperService.deletePapers(testnos);
    }

    @PostMapping("/{testno}/paperinfo")
    public Map<String, Object> findPaperInfo(@PathVariable("testno") Integer testno) {
        return subPaperServices.findPaperInfo(testno);
    }
    
    @PostMapping("/deletesubpaper")
    public Map<String, Object> deleteSubpaper(@RequestBody SubPaper subPaper){
        return subPaperServices.deleteSubpaper(subPaper);
    }
    
    @PostMapping("/changescore")
    public Map<String, Object> changescore(@RequestBody SubPaper subPaper){
        return subPaperServices.changeScore(subPaper);
    }
    
}
