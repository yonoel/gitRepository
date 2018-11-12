package study.domain;

/**
 * @ClassName: ChildChild
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月21日 下午7:33:34
 * 
 */
public abstract class ChildChild extends Child {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte) (a + b);
        System.out.println(c);
    }
}
