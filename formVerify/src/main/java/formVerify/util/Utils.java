package formVerify.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Utils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月3日 上午8:03:09
 * 
 */
public class Utils {
    public static String DateToString(Date birthday) {
        return new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    }

    public static Date StringToDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
