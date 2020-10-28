package com.servi.study.extend.string;

import com.servi.study.log.ServiLogger;
import org.apache.commons.codec.binary.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author servi
 * @date 2020/10/16
 */
public class T0 {

    public static void main(String[] args) {
        getFileValue(s);
    }

    private static String s = "<?xml version='1.0' encoding='GBK'?><CMDATA><FILE_VALUE>UEsDBBQABgAIAAAAIQCfL27mlAEAAJMHAAATAAgCW0NvbnRlbnRfVHlwZXNdLnhtbCCiBAIooAAC" +
            "dxwAZG9jUHJvcHMvYXBwLnhtbFBLBQYAAAAAHQAdAG4HAAA0ehwAAAA=</FILE_VALUE></CMDATA> ";

    private static byte[] getFileValue(String xml) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String startTime = df.format(new Date());
        byte[] fileValue = new byte[0];

//		Element fileValueItem = null;
        try {
//			Reader in = new StringReader(xml);
//			Document doc = new SAXBuilder().build(in);
//			Element root = (Element) doc.getContent().get(0);
//			fileValueItem = root.getChild("FILE_VALUE");
            xml = xml.trim();
            xml = xml.replace("<?xml version='1.0' encoding='GBK'?><CMDATA><FILE_VALUE>", "");
            xml = xml.replace("</FILE_VALUE></CMDATA>", "");
            fileValue = Base64
                    .decodeBase64(xml.getBytes());
        } catch (Exception e) {
            return fileValue;
        }
        String endTime = df.format(new Date());
        ServiLogger.log("getFileValue->" + startTime + "," + endTime);
        return fileValue;
    }
}
