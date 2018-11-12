package java8package;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ClassName: TestConsumerAndPredicate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月6日 下午1:40:54
 * 
 */
public class TestConsumerAndPredicate {
    public static void main(String[] args) {
        Consumer<Integer> intConsumer = x -> x = x + 5;
        Predicate<Integer> intPredicate = x -> x > 5;
        // 调用了test方法
    }
}
