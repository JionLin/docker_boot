package com.jiaolin.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.spring.web.json.Json;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static com.jiaolin.util.SqdzUtil.*;

/**
 * @author johnny
 * @Classname Body
 * @Description
 * @Date 2022/11/3 10:48
 */
@Data
@Slf4j
public class Body {
    private SmsInfo body;

    public static void main(String[] args) {
        System.out.println(generatorSequenceNo(5));
        System.out.println(formatCurrentDate(FORMAT_16));

        // method1();

        method2();
    }

    public static final String PASSWORD ="xx";
    public static final String SYS_CODE ="xx";



    private static void method1() {
        Body body=new Body();
        SmsInfo smsInfo=new SmsInfo();
        smsInfo.setSyscode(SYS_CODE);
        smsInfo.setCode("SR1");
        smsInfo.setBusiParentType("ECS");
        smsInfo.setWildcardNum("0");
        smsInfo.setContent("【上汽大众】你好呀");
        smsInfo.setPhonesAndParams("13145904403");
        smsInfo.setPriority("2");
        body.setBody(smsInfo);
        // String value = JSON.toJSONString(body);
        // System.out.println(value);



        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("syscode",SYS_CODE);
        parameters.put("code","SR1");
        parameters.put("busiParentType","ECS");
        parameters.put("content","【上汽大众】你好呀");
        parameters.put("wildcardNum","0");
        parameters.put("phonesAndParams","13145904403");
        parameters.put("priority","2");

        String mySign = createSign(parameters, PASSWORD);
        smsInfo.setPassword(mySign);
        body.setBody(smsInfo);
        String value2= JSON.toJSONString(body);
        System.out.println(value2);
    }



    private static void method2() {
        SmsStatus smsStatus=new SmsStatus();
        smsStatus.setCode("SR1");
        smsStatus.setSyscode(SYS_CODE);
        smsStatus.setBeginSerialLong(0);

        StatusBody body=new StatusBody();
        body.setBody(smsStatus);

        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("syscode",SYS_CODE);
        parameters.put("code","SR1");
        parameters.put("beginSerialLong",0);

        String mySign = createSign(parameters, PASSWORD);
        smsStatus.setPassword(mySign);
        body.setBody(smsStatus);

        System.out.println(JSON.toJSONString(body));
    }


   /* public static void main(String[] args) {
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        String marChant_id="555555";
        String appId = "444444";
        String timeStamp = "333333";
        String nonceStr = "222222";
        String signType = "MD5";
        parameters.put("marChant_id", marChant_id);
        parameters.put("appId", appId);
        parameters.put("timeStamp", timeStamp);
        parameters.put("nonceStr", nonceStr);
        parameters.put("signType", signType);
        String mySign = createSign(parameters, "kyzc73a29kvay");
        System.out.println("我 的签名是："+mySign);
    }*/

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
        System.out.println("--------------"+sbkey.toString());
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
