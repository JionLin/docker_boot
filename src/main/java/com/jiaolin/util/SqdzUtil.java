package com.jiaolin.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author johnny
 * @Classname SqdzUtil
 * @Description
 * @Date 2022/11/3 10:20
 */
@Slf4j
public class SqdzUtil {
    /**
     * 1. 获取流水号 YYYYMMDDHHmmssSSS +5 位随机数
     * 2。 时间戳 YYYYMMDDHHmmssSSS 18位
     * 3。password
     */

    public static final String number_chars="0123456789";


  /*  public static void main(String[] args) {
        System.out.println(generatorSequenceNo(5));
        System.out.println(formatCurrentDate(FORMAT_16));

        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();

        String mySign = createSign(parameters, "kyzc73a29kvay");
    }*/
    // 17 位
    public static final String FORMAT_16 ="YYYYMMDDHHmmssSSS";

    public static final String  generatorSequenceNo(int length){
        StringBuffer sb=new StringBuffer();
        Random random=new SecureRandom();

        for (int i = 0; i < length; i++) {
            sb.append(number_chars.charAt(random.nextInt(number_chars.length())));
        }
        String value = formatCurrentDate(FORMAT_16) + sb;

        log.info(value);
        return value;
    }

    public static String formatCurrentDate(String format){
        return formatDate(new Date(),format);
    }

    public static final String formatDate(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }


    /**
     * 生成签名
     */
    public static String createSign(SortedMap<Object,Object> parameters,String key){
        StringBuffer sbkey = new StringBuffer();
        //1.将所有参与传参的参数按照accsii排序（升序)
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            //2.空值不传递，不参与签名组串
            if(null != v && !"".equals(v)) {
                sbkey.append(k + "=" + v + "&");
            }
        }
        sbkey=sbkey.append("key="+key);
        System.out.println("sbkey:"+sbkey.toString());
        //3.MD5加密,结果转换为大写字符
        String sign = getMD5(sbkey.toString());
        return sign;
    }

    /**
     * 对字符串进行MD5加密
     */
    public static String getMD5(String str) {
        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
