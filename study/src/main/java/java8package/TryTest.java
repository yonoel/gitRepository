package java8package;

import static java.lang.System.out;

/**
 * @ClassName: TryTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月22日 下午4:27:17
 * 
 */
public class TryTest {
    public static void main(String[] args) {
        // String string = tryTestMethod();
        System.out.println("===========");
        NineTable();
    }

    public static void NineTable() {
        int arr[][] = new int[3][3];
        int a = 2;
        int b = 3 / 2;
        for (int i = 1; i <= 9; i++) {
            arr[a++][b++] = i;
            if (0 == i % 3) {
                a = a - 2;
                b = b - 1;
            } else {
                a = a % 3;
                b = b % 3;
            }
        }
        System.out.println("output:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * @Title: method
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    private static void method() {
        try {
            method1();
            System.out.println("Hello World");
        } catch (Exception e) {
            System.out.println("Exception 1");
        } finally {
            System.out.println("Thank you!");
        }
        System.out.println("Test");

    }

    /**
     * @Title: method1
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    private static void method1() {
        // TODO Auto-generated method stub

    }

    /**
     * @Title: tryTestMethod
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    private static String tryTestMethod() {
        String string = null;
        try {
            string = "try block";
            int i = 5 / 0;
            out.println(string);
            return string;
        } catch (Exception e) {
            out.println(e);
            return string;
        } finally {
            string = "finally block";
            out.println(string);
            // finally语句块在try block 中的return之前执行，然后。。还会退回去？
            return string;
        }

        /*
         * string = "after finally"; out.println(string); return string;
         */

    }
}
