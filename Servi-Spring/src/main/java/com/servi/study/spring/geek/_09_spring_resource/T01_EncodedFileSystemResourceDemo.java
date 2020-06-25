package com.servi.study.spring.geek._09_spring_resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResource} 示例
 *
 * @author servi
 * @see FileSystemResource
 * @see EncodedResource
 * @since
 */
public class T01_EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        String currentJavaFilePath = System.getProperty("user.dir") + "/Servi-Spring/src/main/java/com/servi/study/spring/geek/_09_spring_resource/T01_EncodedFileSystemResourceDemo.java";
        File currentJavaFile = new File(currentJavaFilePath);
        // FileSystemResource => WritableResource => Resource
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
