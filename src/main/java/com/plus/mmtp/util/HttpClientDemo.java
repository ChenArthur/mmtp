/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plus.mmtp.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author storm
 */
public class HttpClientDemo {
    private static final String POST_URL = "http://localhost:9090/SpringMVCExample/home";
    public static void main(String[] args) throws IOException {
        sendGET();
        System.out.println("GET DONE");
        //sendPOST();
        //System.out.println("POST DONE");

    }
    private static void sendGET() throws IOException {
        //http请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://172.16.140.59:443/api/task/list");
        //HttpGet httpGet = new HttpGet("http://www.kuaidi100.com/query?type=yuantong&postid=11111111111");
        httpGet.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
        httpGet.setHeader("Connection", "keep-alive");
        //httpGet.setHeader("Cookie", "__utma=226521935.73826752.1323672782.1325068020.1328770420.6;");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //HTTP响应头部显示
        int StatusCode=httpResponse.getStatusLine().getStatusCode();
        String StatusDescription=httpResponse.getStatusLine().getReasonPhrase();
        System.out.println("StatusCode: "+StatusCode);
        System.out.println("StatusDescription: "+StatusDescription);
        Header headers[] = httpResponse.getAllHeaders();
        for(Header h:headers)
        {
            System.out.println(h.getName()+":"+h.getValue());
        }
        HttpEntity entity = httpResponse.getEntity();
        JSONObject json = new JSONObject();

        System.out.println("json: "+json.get("data"));
        System.out.println("entity: "+EntityUtils.toString(entity));
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
            response.append("\n");
        }
        reader.close();
        // print result
        System.out.println(response.toString());
        */
        httpClient.close();
    }

    private static void sendPOST() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(POST_URL);
        //httpPost.addHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("userName", "Pankaj Kumar"));//dfadsfadsfasdfadsfa 大多数

        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
        httpPost.setEntity(postParams);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        System.out.println("POST Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // print result
        System.out.println(response.toString());
        httpClient.close();

    }

}
