package com.jiaolin.util;

import lombok.Data;

/**
 * @author johnny
 * @Classname SmsInfo
 * @Description
 * @Date 2022/11/3 10:44
 */
@Data
public class SmsInfo {

        private String syscode;

        private String password;

        private String code;

        private String busiParentType;

        private String content;

        private String wildcardNum;

        private String phonesAndParams;


        private String priority;


}
