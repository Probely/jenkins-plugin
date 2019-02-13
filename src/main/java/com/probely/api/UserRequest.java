package com.probely.api;

import com.probely.util.ApiUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

public class UserRequest {
    private final String authToken;
    private final String baseUrl;
    private final HttpClient httpClient;

    public UserRequest(String authToken, String url, HttpClient httpClient) {
        this.authToken = authToken;
        this.baseUrl = url;
        this.httpClient = httpClient;
    }

    public User get() throws IOException {
        HttpGet request = new HttpGet(baseUrl);
        ResponseHandler<String> handler = ApiUtils.buildResponseHandler();
        ApiUtils.addRequiredHeaders(authToken, request);
        String response = httpClient.execute(request, handler);
        return UserDeserializer.deserialize(response);
    }
}
