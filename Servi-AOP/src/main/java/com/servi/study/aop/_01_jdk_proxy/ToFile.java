package com.servi.study.aop._01_jdk_proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ToFile {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = null;
        try {
            byte[] classFile = ProxyGenerator.generateProxyClass("ih",
                    new Class[]{IService.class});
            out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\" + "ih.class");
            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
