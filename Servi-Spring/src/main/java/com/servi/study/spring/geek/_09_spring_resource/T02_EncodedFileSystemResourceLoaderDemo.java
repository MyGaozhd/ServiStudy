package com.servi.study.spring.geek._09_spring_resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResourceLoader} 示例
 *
 * @author servi
 * @see FileSystemResourceLoader
 * @see FileSystemResource
 * @see EncodedResource
 * @since
 */
public class T02_EncodedFileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        /**注意最开始需要增加 </>**/
        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/Servi-Spring/src/main/java/com/servi/study/spring/geek/_09_spring_resource/T02_EncodedFileSystemResourceLoaderDemo.java";
        // 新建一个 FileSystemResourceLoader 对象
        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        // FileSystemResource => WritableResource => Resource
        Resource resource = resourceLoader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
