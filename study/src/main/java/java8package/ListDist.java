package java8package;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName: ListDist
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月22日 下午7:09:14
 * 
 */
public class ListDist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(100);

        // 笔试题： 返回一个数组或者列表，里面有100个数，1~100，不可重复，随机打乱
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println(list);
    }
}
