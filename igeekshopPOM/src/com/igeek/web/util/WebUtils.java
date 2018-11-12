package com.igeek.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: WebUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月25日 下午5:46:01
 * 
 */
public class WebUtils {

    public static <T> List<T> request2List(HttpServletRequest request, Class<T> clazz)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {

        // Map<String, String[]> paramterMap = request.getParameterMap();
        // Set<Entry<String, String[]>> paramterSet =
        // request.getParameterMap().entrySet();

        // List<String> keyList =
        // paramterMap.keySet().stream().collect(Collectors.toList());
        // List<String[]> valueList =
        // paramterMap.values().stream().collect(Collectors.toList());
       

        //Map<String, List<T>> orderMaps = new HashMap<>();
        //Map<String, String[]> ordersMap = new HashMap<>();
        // List<String> oids = Arrays.asList(request.getParameterValues("oids"));

        /*
         * String oid = null; // 注意key的size和value的size是匹配的，但是value可以是个数组 if
         * (oids.size() > 1) { // 第一个参数是methodflag可以跳过 for (int i = 1; i <
         * keyList.size(); i++) {
         * 
         * String key = keyList.get(i);
         * 
         * // oid即是开始又是结束的标志，!当只有一个oid时，没有结束的标志 if (key.contains("oid")) { oid =
         * key; if (!list.isEmpty()) { // 返回的map增加列表 orderMaps.put(oid, list); }
         * // 清空生成product的参数列表 ordersMap.clear(); } ordersMap.put(key,
         * valueList.get(i)); if (i % 4 == 2) { T bean = clazz.newInstance();
         * BeanUtils.populate(bean, ordersMap); list.add(bean); } } } else { //
         * 只有一个Oid-->生成的是一个productDTO的list列表 for (int i = 0; i < keyList.size();
         * i++) { String key = keyList.get(i); // 注意valuelist里的值是个数组 key倒是写死了6个
         * ordersMap.put(key, valueList.get(i)); //
         * 关于product这个对象每四个参数一循环，前两个参数为flag和oid if (i % 4 == 2 && i != 2) { T
         * bean = clazz.newInstance(); BeanUtils.populate(bean, ordersMap);
         * list.add(bean); } } orderMaps.put(oids.get(0), list);
         * 
         * }
         */
        List<T> List = new ArrayList<>();
        String[] pids = request.getParameterValues("pid");
        String[] shopPricees = request.getParameterValues("shopPrice");
        String[] quantities = request.getParameterValues("quantity");
        String[] pimages = request.getParameterValues("pimage");
        String[] pnames = request.getParameterValues("pname");
        for (int i = 0; i < pids.length; i++) {
            T bean = clazz.newInstance();
            Map<String, String> map = new HashMap<>();
            map.put("pid", pids[i]);
            map.put("shopPrice", shopPricees[i]);
            map.put("quantity", quantities[i]);
            double subtotal = Double.parseDouble(quantities[i]) * Double.parseDouble(shopPricees[i]);
            map.put("subtotal", Double.toString(subtotal));
            map.put("pimage", pimages[i]);
            map.put("pname", pnames[i]);
            BeanUtils.populate(bean, map);
            List.add(bean);

        }
        return List;
    }

    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    // 定义数据源对象
    private static JedisPool jedispool;
    static {
        try {
            // 读取配置文件信息
            InputStream is = WebUtils.class.getClassLoader().getResourceAsStream("redis.properties");
            // 实例化properties对象
            Properties pr = new Properties();
            // 从输入流中读取属性列表（键和元素对）
            pr.load(is);
            // 创建jedispool的连接池的配置对象
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            // 设置配置连接池参数

            poolConfig.setMaxIdle(Integer.parseInt(pr.getProperty("redis.maxIdle")));
            poolConfig.setMinIdle(Integer.parseInt(pr.getProperty("redis.minIdle")));
            poolConfig.setMaxTotal(Integer.parseInt(pr.getProperty("redis.maxTotal")));
            // 创建jedis连接池对象
            jedispool = new JedisPool(poolConfig, pr.getProperty("redis.host"),
                    Integer.parseInt(pr.getProperty("redis.port")));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        return jedispool.getResource();
    }

    public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "smtp.126.com");
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true

        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("qidongting", "igeekhome123456");// 授权码
            }
        };

        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("qidongting@126.com")); // 设置发送者

        message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

        message.setSubject("用户激活");
        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3.创建 Transport用于将邮件发送

        Transport.send(message);
    }

    /**
     * 将request对象转换成T对象
     * 
     * @param request
     * @param clazz
     * @return
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            Map<String, String[]> properties = request.getParameterMap();

            BeanUtils.populate(bean, properties);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成UUID
     * 
     * @return
     */
    public static String makeId() {
        return UUID.randomUUID().toString();
    }

    public static void object2Json(Object object, HttpServletResponse response) {
        try {
            Gson gson = new Gson();
            String jsonstr = gson.toJson(object);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println(jsonstr);
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
