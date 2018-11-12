package study.domain;

import java.util.HashMap;

/**
 * @ClassName: TestMap
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月31日 上午7:28:36
 * 
 */
public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.put("g", 7);
        map.entrySet().forEach(System.out::println);
    }
}
