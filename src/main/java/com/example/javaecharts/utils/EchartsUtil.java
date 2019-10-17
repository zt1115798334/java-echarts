package com.example.javaecharts.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EchartsUtil {
    private static String url = "http://localhost:6666";
    private static final String SUCCESS_CODE = "1";

    public static String generateEchartsBase64(String option) throws ClientProtocolException, IOException {
        String base64 = "";
        if (option == null) {
            return base64;
        }
        option = option.replaceAll("\\s+", "").replaceAll("\"", "'");

        // 将option字符串作为参数发送给echartsConvert服务器
        JSONObject params = new JSONObject();
        params.put("reqMethod", "echarts");
        params.put("opt", JSONObject.parseObject(option));
        System.out.println("params.toJSONString() = " + params.toJSONString());
        String response = HttpUtil.postUrl(url, params.getInnerMap(), "utf-8");
        System.out.println("response = " + response);
        // 解析echartsConvert响应
        JSONObject responseJson = JSON.parseObject(response);
        String code = responseJson.getString("code");

        // 如果echartsConvert正常返回
        if (SUCCESS_CODE.equals(code)) {
            base64 = responseJson.getString("data");
        }
        // 未正常返回
        else {
            String string = responseJson.getString("msg");
            throw new RuntimeException(string);
        }

        return base64;
    }
}
