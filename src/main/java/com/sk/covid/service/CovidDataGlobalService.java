package com.sk.covid.service;

import javax.sql.DataSource;
import org.springframework.stereotype.Service;

@Service
public class CovidDataGlobalService {
  private final DataSource dataSource;

  public CovidDataGlobalService(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
