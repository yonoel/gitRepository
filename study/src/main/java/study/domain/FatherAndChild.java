package study.domain;

/**
 * @ClassName: FatherAndChild
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月8日 上午10:54:14
 * 
 */
public class FatherAndChild {
    public static void main(String[] args) {
        // Child child = (Child) new Father();
        Father father = new Child();
        Child child = new Child();
        System.out.println(father.getClass().getClasses().length);
    }
}
