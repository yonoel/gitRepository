package com.igeek.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MetaController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午6:05:20
 * 
 */
@RestController
@RequestMapping("/meta/")
public class MetaController extends BaseController{

   

    @GetMapping("/queryall")
    public Map<String, Object> queryDiffAndType() {
        // return iMasterServices.queryDiffAndType();
        Map<String, Object> map = iMastersService.queryDiffAndType();
        return map;
    }
}
