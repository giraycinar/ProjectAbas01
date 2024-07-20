package com.giray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestExample {
    public static void main(String[] args) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();


        httpClient.setRequestMethod("GET");

        int responseCode = httpClient.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println("GET Response Body: " + response.toString());
        } else {
            System.out.println("GET request failed");
        }
    }
}