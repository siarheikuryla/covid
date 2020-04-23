package com.sk.covid;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(CovidApplication.class, args);
  }

}
