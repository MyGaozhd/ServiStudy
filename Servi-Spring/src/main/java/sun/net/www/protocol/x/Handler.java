package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * X 协议 {@link URLStreamHandler} 实现
 *
 * @author servi
 * 协议的名称是 根据 包名 sun.net.www.protocol.x 来确定的。
 * protocol 后面的 x 就是协议的名称 就是 handler 的包的最后一级
 */
public class Handler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new XURLConnection(u);
    }
}
