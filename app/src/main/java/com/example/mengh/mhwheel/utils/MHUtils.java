package com.example.mengh.mhwheel.utils;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;


import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by HMH on 2017/7/31.
 */

public class MHUtils {
    /*
    日期转换
     */
    public static String timeStrToSecond(Long time) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
        return format;
    }

    /*
    退出app
     */
    private static Boolean isExit = false;

    public static void exitBy2Click(Activity context) {
        Timer tExit = null;
        if (!isExit) {
            isExit = true; // 准备退出
            Toast.makeText(context, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
//            context.finish();
//            System.exit(0);
            ActivityManagerUtils.getInstance().exit();
        }
    }

    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static String Bytes2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }

    public static byte[] Hex2Bytes(String hexStr) {
        if (hexStr.length() % 2 != 0) {
            hexStr = "0" + hexStr;
        }
        byte[] bytes = new byte[hexStr.length() / 2];
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) (Integer.parseInt(hexStr.substring(i * 2, i * 2 + 2), 16) + 256);
        }
        return bytes;
    }

    public static String getETText(EditText editText) {
        return editText.getText().toString().trim();
    }

}
