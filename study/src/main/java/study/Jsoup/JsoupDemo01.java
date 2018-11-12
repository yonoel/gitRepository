package study.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @ClassName: JsoupDemo01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月6日 下午2:42:00
 * 
 */
public class JsoupDemo01 {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
    }
}
