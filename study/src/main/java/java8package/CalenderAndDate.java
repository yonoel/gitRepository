package java8package;

import java.util.Calendar;

/**  
* @ClassName: CalenderAndDate  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 上午7:42:39    
*    
*/
public class CalenderAndDate {
    public static void main(String[] args) {
        Calendar calendar = new Calendar.Builder().setDate(2018, 10, 20).build();
        System.out.println(calendar);
    }
}
