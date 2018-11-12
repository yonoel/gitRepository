package servlet.studyResponseOBJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName: TestIO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年6月28日 上午10:42:14
 * 
 */
public class TestIO {

    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream("D:\\qianyizhen\\webWorkSpace\\demobass8.5\\src\\a.txt");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        OutputStream os = null;
        byte[] barr = new byte[1024];
        int len = 0;
        try {
            os = new FileOutputStream("b.txt");
            while ((len = is.read(barr)) > 0) {
                os.write(barr, 0, len);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
