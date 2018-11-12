package com.web.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月6日 上午8:19:59
 * 
 */
public class Test {
    public static void main(String[] args) {
        InputStream in = Test.class.getResourceAsStream("/DirtyWord.txt");
        List<String> list = new ArrayList<>();
        String cn = "中文";
        try {
            // byte[] barr = Files.readAllBytes(Paths.get("/DirtyWord.txt"));
            // read file must be readed by this default charset ,then it can be
            // compare with local String (in other charset)
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "GBK"));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            for (String string : list) {
                if (cn.contains(string)) {
                    System.out.println("exsit");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
