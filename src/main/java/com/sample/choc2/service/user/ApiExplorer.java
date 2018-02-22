package com.sample.choc2.service.user;

/* Java 샘플 코드 */
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471057/ToxctyInfoService/getDermaToxctyInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=wyOiM1cK4eUGSUp4vLIIh0rc3ANVqsSktBiDowFEfAHyk6ly9LFvBeqHQJs0iAwRLF5%2FlKTlydxe6DrZmYFVfA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("categoryname","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*물질분류명*/
        urlBuilder.append("&" + URLEncoder.encode("chemnamekor","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*국문물질명*/
        urlBuilder.append("&" + URLEncoder.encode("chemnameeng","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*영문물질명*/
        urlBuilder.append("&" + URLEncoder.encode("casno","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*CAS No*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과수*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}