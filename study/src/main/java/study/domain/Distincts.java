package study.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: Distincts
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月28日 上午10:39:26
 * 
 */
public class Distincts {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(4);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(9);

        List<Integer> list2 =  list.stream().distinct().collect(Collectors.toList());
        System.out.println(list2);
    }
}
