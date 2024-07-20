package com.giray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestExample {
    public static void main(String[] args) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();


        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("Content-Type", "application/json; utf-8");
        httpClient.setRequestProperty("Accept", "application/json");
        httpClient.setDoOutput(true);


        String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

        try (OutputStream os = httpClient.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("POST Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println("POST Response Body: " + response.toString());
        } else {
            System.out.println("POST request failed");
        }
    }
}
