package com.igeek.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.igeek.dao.IEmpMapper;
import com.igeek.domain.Emp;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls.Criteria;

@Service
public class EmpServicesImp implements IEmpServices {
    // services 的map ，可以丢给controller做model
    private Map<String, Object> map = new HashMap<>();

    @Resource // 这是JSR-250的注解和AUTOwire效果相似，但是更安全
    private IEmpMapper mapper;

    public EmpServicesImp() {

    }

    // 所有服务的判断方法 只负责逻辑 1->成功，其他根据具体order来甄别

    protected void judgeServices(int flag, String order, Object obj) {
        // 首先判断Obj

        if (flag == 1) {
            String success = String.format("%s成功", order);
            // 给控制层调表明成功的标识
            this.map.put("flag", true);
            this.map.put("order", success);
            this.map.put("emp", obj);
        } else {
            map.put("flag", false);
            if (flag == 0) {
                String faild = String.format("%s失败", order);
                this.map.put("order", faild);
            } else if (flag == -1) {
                String faild = String.format("%s失败，这位雇员已经存在", order);
                this.map.put("order", faild);
            } else if (flag == -2) {
                String faild = String.format("%s失败，这位雇员不存在", order);
                this.map.put("order", faild);
            } else if (flag == -3) {
                String faild = String.format("%s失败，密码有错", order);
                this.map.put("order", faild);
            }
        }

    }

    public Map<String, Object> queryEmp(Emp emp) {
        String order = "查询单个雇员";
        int flag = 0;
        // 这个方法是全字段匹配...
        Emp emp2 = mapper.selectOne(emp);
        if (emp2 == null) {
            // 不存在
            flag = -2;
        } else {
            flag = 1;
        }
        judgeServices(flag, order, emp2);

        return map;
    }

    public Map<String, Object> queryAll(String pageNum) {
        String order = "查询所有";
        int flag;
        Example empExample = new Example(Emp.class);
        tk.mybatis.mapper.entity.Example.Criteria criteria = empExample.createCriteria();
        
        // 分页器，规定了每页十条 计算总数
        Page<Emp> pages = PageHelper.startPage(Integer.parseInt(pageNum), 10, true);
        // 查询分页数
        // System.out.println("counts:" + pages.getCountColumn());
        // PageHelper.startPage(Integer.parseInt(pageNum), 10);
        List<Emp> list = mapper.selectAll();
        // System.out.println(pages.getPages());
        // System.out.println(pages.getResult());
        // if (!list.isEmpty()) {
        // list.forEach(System.out::println);
        // }
        flag = (list == null ? 0 : 1);
        judgeServices(flag, order, pages);
        map.put("pages", pages.getPages());
        return this.map;
    }

    // insert
    public Map<String, Object> insertEmp(Emp emp) {
        String order = "增加新雇员";

        int flag;
       
        Emp emp2 = mapper.selectOne(emp);
        if (emp2 != null) {
            flag = -1;

        } else {
            flag = mapper.insert(emp);

        }

        judgeServices(flag, order, 1);

        return map;
    }

    // delete
    public Map<String, Object> deleteEmp(Emp emp) {
        String order = "删除雇员";

        int flag;

        Emp emp2 = mapper.selectOne(emp);
        if (emp2 == null) {
            flag = -2;
        } else {
            flag = mapper.delete(emp);
        }

        judgeServices(flag, order, 1);

        return map;
    }

    // update
    public Map<String, Object> updateEmp(Emp emp) {
        String order = "修改雇员数据";

        int flag;

        Emp emp2 = mapper.selectOne(emp);
        if (emp2 == null) {
            flag = -2;
        } else {
            flag = mapper.updateByExample(emp, emp);
        }

        judgeServices(flag, order, 1);

        return map;
    }

}
