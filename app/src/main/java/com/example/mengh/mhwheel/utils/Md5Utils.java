package com.example.mengh.mhwheel.utils;

import java.security.MessageDigest;

/**
 * ----------------------------------------------------------------------------
 * 功能描述：MD5加密,java String 转变成MD5 String
 * ----------------------------------------------------------------------------
 */
public class Md5Utils {

    public static String md5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                int v = (int) b[i];
                v = v < 0 ? 0x100 + v : v;
                String cc = Integer.toHexString(v);
                if (cc.length() == 1)
                    sb.append('0');
                sb.append(cc);
            }
            return sb.toString();
        }
        catch (Exception e) {
        }
        return "";
    }
}
