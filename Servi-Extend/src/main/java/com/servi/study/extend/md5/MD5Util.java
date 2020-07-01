package com.servi.study.extend.md5;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author servi
 * @date 2020/7/1
 */
@Slf4j
public class MD5Util {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            test("aaaaaq" + i);
        }
    }

    public static void test(String a) {
        String m1 = md5(a);
        String m2 = md5(a);
        log.info("md5->" + m1);
        log.info("makeMD5->" + m2);
        log.info(a + "->eq->" + (m1.equals(m2)));
    }

    public static String md5(String content) {
        try {
            byte[] buf = null;
            buf = content.getBytes("utf-8");
            MessageDigest md5 = null;
            md5 = MessageDigest.getInstance("MD5");
            md5.update(buf);
            byte[] tmp = md5.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : tmp) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (Exception e) {

        }
        return null;
    }

    public static String makeMD5(String password) {

        return getMD5String(password);
    }

    /**
     * Md5加密字符串，采用utf-8解码成bytes
     *
     * @param value
     * @return
     */
    private static String getMD5String(String value) {

        try {
            return getMD5String(value.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {

        }
        return value;
    }

    /**
     * 对bytes数组进行MD5加密
     *
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String getMD5String(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] e = md.digest(bytes);
        return toHexString(e);
    }

    /**
     * bytes 数组 转16进制字符串
     *
     * @param bytes
     * @return
     */
    private static String toHexString(byte bytes[]) {

        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < bytes.length; n++) {
            stmp = Integer.toHexString(bytes[n] & 0xff);
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }

        return hs.toString();
    }
}
