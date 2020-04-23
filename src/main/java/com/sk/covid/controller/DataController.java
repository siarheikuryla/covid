package com.sk.covid.controller;

import com.sk.covid.service.DataRetrievalService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

  private DataRetrievalService dataRetrievalService;

  @Autowired
  public DataController(DataRetrievalService dataRetrievalService) {
    this.dataRetrievalService = dataRetrievalService;
  }

  @GetMapping
  public void getData() throws IOException {
    dataRetrievalService.retrieveDataFromSource();
  }
}
