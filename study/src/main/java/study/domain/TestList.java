package study.domain;

import java.util.ArrayList;
import java.util.List;

/**  
* @ClassName: TestList  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月31日 上午7:43:22    
*    
*/
public class TestList {
    public static void main(String[] args) {
        ListTest1 listTest1 = new ListTest1();
        listTest1.getList().add(5);
        System.out.println(listTest1.getList());
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        listTest1.setList(list);
        System.out.println(listTest1.getList());
    }
}
