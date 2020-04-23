package com.sk.covid.service;


import java.io.IOException;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class HttpClientService {

  private final OkHttpClient okHttpClient;

  public HttpClientService(OkHttpClient okHttpClient) {
    this.okHttpClient = okHttpClient;
  }

  public Response sendGetRequestWithoutHeaders(String url, Map<String, String> queryParameters)
      throws IOException {
    HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

    if (queryParameters != null) {
      queryParameters.keySet().stream().forEach(key -> urlBuilder.addQueryParameter(key, queryParameters.get(key)));
    }
    String urlToRequest = urlBuilder.build().toString();
    Request httpGetRequest = new Request.Builder()
        .url(urlToRequest)
        .build();
    try (Response response = okHttpClient.newCall(httpGetRequest).execute()) {
      return response;
    }
  }

}
