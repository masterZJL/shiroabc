package com.zjl.study.shiroabc.utils;

import java.util.Random;

public class SaltUtils {

    private static char[] chs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    public static String getSalt(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<n; i++) {
            sb.append(chs[new Random().nextInt(chs.length)]);
        }
        return sb.toString();
    }
}
