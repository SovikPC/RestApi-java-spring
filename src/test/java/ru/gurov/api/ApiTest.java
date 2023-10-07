package ru.gurov.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

//    @Test
//    public void testGetRequest() {
//        String response = sendGetRequest("http://localhost:8080/api/equipment");
//        assertEquals(HttpStatus.OK, response);
//    }
//
//    public String sendGetRequest(String url) {
//        StringBuilder response = new StringBuilder();
//
//        try {
//            URL apiUrl = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
//            connection.setRequestMethod("GET");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return response.toString();
//    }
//
//    @Test
//    public void testPostRequest(){
//        HttpClient
//    }
//
//    public String sendPostRequest(String url, String body){
//        StringBuilder response =
//    }

    @Test
    public void deleteRequest(){
        String response = sendDeleteRequest("http://localhost:8080/api/equipment/4");
        assertEquals(HttpStatus.OK, response);
    }

    public String sendDeleteRequest(String url){
        StringBuilder response = new StringBuilder();
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("DELETE");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }
}
