package com.demo.service.utils;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public class EmailUtils {

    public static boolean validate(String email) {
        if(email == null) {
            return false;
        }
        //判断email的格式是否正确
        return true;
    }
}