package com.sk.covid.service;

import java.io.IOException;
import java.util.List;
import okhttp3.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class DataRetrievalService {

  private static final String URL = "";

  private final HttpClientService httpClientService;

  public DataRetrievalService(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  public void retrieveDataFromSource() throws IOException {
    Response response = httpClientService.sendGetRequestWithoutHeaders(URL, null);
    CSVParser parse = CSVParser
        .parse(response.body().string(), CSVFormat.EXCEL);
    List<CSVRecord> records = parse.getRecords();
    System.out.println(records);

  }


}
