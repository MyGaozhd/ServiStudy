package sun.net.www.protocol.x;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * X Handler 测试示例
 *
 * @author servi
 * @since
 */
public class HandlerTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("x:spring_resource\\default.properties"); // 类似于 classpath:spring_resource\default.properties
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
