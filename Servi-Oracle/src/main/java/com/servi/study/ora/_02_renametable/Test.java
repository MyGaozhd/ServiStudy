package com.servi.study.ora._02_renametable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        get();
        StringBuilder s = new StringBuilder("");

    }

    public static String get() {
        String s = null;
        boolean isFirst = true;
        File file = new File("C:\\Users\\Administrator\\Desktop\\2.txt");
        if (file.isFile() && file.exists()) { //判断文件或目录是否存在
            try {
                InputStream in = new FileInputStream(file);
                try {
                    Reader reader = new InputStreamReader(in, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String lineTxt = null;
                    List<String> list = new ArrayList<>();
                    try {
                        while ((lineTxt = bufferedReader.readLine()) != null) {
                            s = lineTxt;
                        }
                    } catch (IOException e) {
                        System.out.println("异常：读取文件出错");
                        e.printStackTrace();
                    }

                    try {
                        in.close();
                    } catch (IOException e) {
                        System.out.println("异常：不支持编码");
                        e.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e) {
                    System.out.println("异常：不支持编码");
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.out.println("异常：文件未找到");
                e.printStackTrace();
            }
        } else {
            System.out.println("文件或目录不存在");
        }
        System.out.println(s);
        return s;
    }
}