package com.servi.study.extend.xfire;

import com.google.gson.Gson;
import com.servi.study.log.ServiLogger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.apache.commons.codec.binary.Base64;

import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class XfireTest1 {

    public static void main(String[] args) {
        StringBuffer request = new StringBuffer();
        request.append("<CMDATA>");
        request.append("<BUSI_SERIAL_NO>" + "1001A110000000102LI3" + "</BUSI_SERIAL_NO>");
        request.append("<DOCNAME>" + "预置分类1" + "</DOCNAME>");
        request.append("<FILENAME>" + "分配.png" + "</FILENAME>");
        request.append("</CMDATA>");

        String result = WSUtil.getWebserviceResponse("http://10.16.4.23:8599/TIMS-Server/services/ContentInfoService?wsdl",
                "CMForMobile_OnePicDownload", request.toString());

        Gson gson = new Gson();

        ServiLogger.log("nc-cloud:" + result);

        ServiLogger.log("\r\n ======================");

        byte[] fileValue = new byte[0];
        fileValue = getFileValue(result);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        ServiLogger.log("移动审批调用影像getCMImage********参数fileValue值："+fileValue);
        Map<String, Object> downloadMap = new HashMap<String, Object>();
        downloadMap.put("downloaded", fileValue);

        ServiLogger.log(gson.toJson(downloadMap));

    }

    private static byte[] getFileValue(String xml) {

        byte[] fileValue = new byte[0];

        Element fileValueItem = null;
        try {
            Reader in = new StringReader(xml);
            Document doc = new SAXBuilder().build(in);
            Element root = (Element) doc.getContent().get(0);
            fileValueItem = root.getChild("FILE_VALUE");

            fileValue = Base64
                    .decodeBase64(fileValueItem.getValue().getBytes());
        } catch (Exception e) {
            ServiLogger.log("移动审批调用影像getFileValue********异常：" + e.getMessage());
            return fileValue;
        }
        if (fileValueItem == null || fileValueItem.getValue() == null) {
            return fileValue;
        }

        return fileValue;
    }
}
