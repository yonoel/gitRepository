package study.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DoubleList
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月30日 上午9:10:08
 * 
 */
public class DoubleList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("zs");
        list.add("ls");
        list.add("ww");
        list.add("xx");
        List<List<String>> list2 = new ArrayList<List<String>>();
        list2.add(list);
        //list2.forEach(p -> p.forEach(x -> System.out.println(x)));
   
        for (int i = 0; i < list2.size(); i++) {
           
            for (int j = 0; j < list2.get(i).size(); j++) {
                System.out.println(list2.get(i).get(j));
            }
        }
    }
}
