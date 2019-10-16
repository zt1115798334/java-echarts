package com.example.javaecharts.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtil {

    public static String post(String url, Map<String, String> params, String charset) throws IOException {
        String responseEntity = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> nameValuePairs = params.entrySet().stream()
                .map(entity -> new BasicNameValuePair(entity.getKey(), entity.getValue()))
                .collect(Collectors.toList());

        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, charset));
        CloseableHttpResponse response = client.execute(httpPost);

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            responseEntity = EntityUtils.toString(entity, charset);
        }

        EntityUtils.consume(entity);
        response.close();
        return responseEntity;


    }
}
