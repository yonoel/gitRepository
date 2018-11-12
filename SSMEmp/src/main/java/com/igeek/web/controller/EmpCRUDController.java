package com.igeek.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igeek.services.IDeptServices;
import com.igeek.services.IEmpServices;

/**
 * @ClassName: EmpCRUDController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月21日 上午8:32:17
 * 
 */
@RestController
@RequestMapping("/main")
public class EmpCRUDController {
    @Resource
    private IEmpServices empServices;
    @Resource
    private IDeptServices deptServices;

    // 分页查询后台所有信息
    @GetMapping("/query")
    public Map<String, Object> queryHandler(@RequestParam String data, @RequestParam String pageNum) {
        // 因为我前台写了一个getArguments方法，传递过来的参数以 getArguments = XXXXXX的形式传递
        // if (pagenum != null) {
        // System.out.println(pagenum);
        // }
        // // 那么问题来了。。这个里数据里不含有总页数的信息
        // System.out.println(pagenum);
        // Map<String, String[]> map2 = request.getParameterMap();
        // System.out.println("这是参数列表"+getArguments);
        // Set<Entry<String, String[]>> set = map2.entrySet();

        // 取参数集合,我觉得最好能变成Map而不是list
        // List<String> list = Arrays.asList(data.split("&"));
        // list.forEach(System.out::println);
        // empName=
        // startdate=
        // pageNum=1
        // Map<String, String> argumentsMap = null;
        // String pageNum = "pageNum";
        // String pageNum2 = null;
        // for (int i = 0; i < list.size(); i++) {
        // String argument = list.get(i);
        // if (argument.contains(pageNum)) {
        // String[] arr = argument.split("=");
        // System.out.println("arr[0]" + arr[0]);
        // System.out.println("arr[1]" + arr[1]);
        // if (arr[1].matches("\\d")) {
        // pageNum2 = arr[1];
        // }
        //
        // }
        // }

        // System.out.println("这里是map对象");
        // map.entrySet().forEach(System.out::println);
        Map<String, Object> map = empServices.queryAll(pageNum);
   
        map.putAll(deptServices.queryAll());
        return map;
    }

}
