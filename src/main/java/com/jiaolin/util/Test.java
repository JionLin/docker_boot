package com.jiaolin.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author johnny
 * @Classname Test
 * @Description 两个不同的list 进行求相同的数据,然后在进行转换成一个对象,拿到对应的数据
 * @Date 2022/11/4 13:46
 */
public class Test {
    @Data
    class Person {
        private String userName;
        private int bloodVolume;
        public Person(String userName, int bloodVolume) {
            this.userName = userName;
            this.bloodVolume = bloodVolume;
        }
    }

    @Data
    class Rule {
        private String userName;

        private int bloodVolume;
        private String align;

        public Rule(String userName, int bloodVolume, String align) {
            this.userName = userName;
            this.bloodVolume = bloodVolume;
            this.align = align;
        }
    }

    @Data
    class Hero {
        private String userName;
        private int bloodVolume;
        private String align;
        public Hero(String userName, int bloodVolume, String align) {
            this.userName = userName;
            this.bloodVolume = bloodVolume;
            this.align = align;
        }
    }



    @org.junit.Test
    public void test(){
        List<Person> userListA = Arrays.asList(
                new Person("关羽", 926),
                new Person("赵云", 916),
                new Person("张飞", 906),
                new Person("许褚", 911));
        List<Rule> userListB = Arrays.asList(
                new Rule("关羽", 926,"字·云长-关公-武财神-汉寿亭侯"),
                new Rule("张飞", 916,"字·益德-勇武过人-西乡侯"),
                new Rule("刘备", 00,"字·玄德-百折不挠-汉昭烈帝"),
                new Rule("赵云", 916,"字·子龙-忠义-永昌亭侯"),
                new Rule("周瑜", 22,"字·公瑾-文武兼备-永昌亭侯"),
                new Rule("许褚", 33,"字·仲康-勇力绝人-虎侯"));

        List<Hero> commonList = userListA.stream()
                .map((uA) -> {
                    return userListB.stream()
                            .filter((uB) -> {
                                return StringUtils.equals(uB.getUserName(), uA.getUserName())&&(uB.getBloodVolume()== uA.bloodVolume);
                            })
                            .map((uB) -> {
                                return new Hero(uB.getUserName(), uA.getBloodVolume(), uB.align);
                            })
                            .collect(Collectors.toList());
                }) // 结果类型 Steam<List<Hero>>
                .flatMap(List::stream) // 结果类型 Steam<Hero>
                .collect(Collectors.toList()); // 结果类型 List<Hero>

        System.out.println(JSON.toJSONString(commonList));

    }
}
