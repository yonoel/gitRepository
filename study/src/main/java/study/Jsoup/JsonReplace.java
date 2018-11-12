package study.Jsoup;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import study.domain.User;

/**
 * @ClassName: JsonReplace
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月19日 上午8:02:06
 * 
 */
public class JsonReplace {
    public static void main(String[] args) {
       
        List<User> list = new ArrayList<>();
        list.add(new User("jack"));
        list.add(new User("rose"));
        String liststr = JSON.toJSONString(list);
        System.out.println(liststr);
        String str2 = "[abc]";
        System.out.println(str2);
        str2 = str2.replace("[", "");
        System.out.println(str2);
        System.out.println(liststr);
    }
}
