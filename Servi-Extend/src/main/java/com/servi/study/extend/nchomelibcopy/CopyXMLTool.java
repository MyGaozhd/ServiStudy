package com.servi.study.extend.nchomelibcopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyXMLTool {

    private static final String BASE_PATH = "D:\\develop\\java\\nchome";

    private static final String[] FROM_PATH = new String[]{
            "ncchome0512\\ncchome0511\\modules",
            "ncchome0512\\ncchome0511/hotwebs",
            "ncchome0512\\ncchome0511\\external\\lib",
            "ncchome0512\\ncchome0511\\lib"
    };

    private static final String[] TO_PATH = new String[]{
            "libs\\xml",
            "libs\\xml",
            "libs\\xml",
            "libs\\xml"
    };

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < FROM_PATH.length; i++) {
            String fromPath = BASE_PATH + File.separator + FROM_PATH[i];
            String toPath = BASE_PATH + File.separator + TO_PATH[i];
            copyJarFile(fromPath, toPath);
        }
    }

    private static void copyJarFile(String fromPath, String toPath) {
        File srcFile = new File(fromPath);
        File[] files = srcFile.listFiles();
        File aimFile = new File(toPath);

        if (!aimFile.exists()) {
            aimFile.mkdirs();
        }

        for (File file : files) {
            if (file.isDirectory()) {
                copyJarFile(file.getPath(), toPath);
            }
            String name = file.getName();
            if (!name.endsWith(".xml")) {
                continue;
            }
            System.out.println(file.getName() + "->" + aimFile + File.separator + file.getName());

            File tmpfile = new File(aimFile + File.separator + file.getName());
            if (tmpfile.exists()) {
                tmpfile.delete();
            }
            copyNio(file, tmpfile);
        }
        System.out.println("---------------- 移动jar文件成功  -----------------");
    }

    public static void copyNio(File from, File to) {
        FileChannel input = null;
        FileChannel output = null;

        try {
            input = new FileInputStream(from).getChannel();
            output = new FileOutputStream(to).getChannel();
            output.transferFrom(input, 0, input.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
