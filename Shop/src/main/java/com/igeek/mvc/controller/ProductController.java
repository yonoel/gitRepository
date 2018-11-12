package com.igeek.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igeek.mvc.service.ICategoryServices;
import com.igeek.mvc.service.IProductServices;

/**
 * @ClassName: ProductController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月3日 上午11:16:56
 * 
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductServices iProductServices;
    @Autowired
    private ICategoryServices icategoryServices;

    @RequestMapping("/queryhot")
    public Map<String,Object> doQueryHot(@RequestParam("pageNum") String pageNum, @RequestParam("pageSize") String pageSize) {
        
        return iProductServices.queryList(Integer.parseInt(pageNum), Integer.parseInt(pageSize), "queryhot");
    }

    @RequestMapping("/querynew")
    public Map<String,Object> doQueryNew(@RequestParam("pageNum") String pageNum, @RequestParam("pageSize") String pageSize) {
      
        return   iProductServices.queryList(Integer.parseInt(pageNum), Integer.parseInt(pageSize), "querynew");
    }

    @RequestMapping("/queryCategory")
    public Map<String,Object> doQueeryCategory(@RequestParam("methodflag") String methodflag) {
       
        return  icategoryServices.queryCategory();
    }
}
