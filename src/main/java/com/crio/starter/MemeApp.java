/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package com.crio.starter;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class MemeApp {

  public static void main(String[] args) {
    SpringApplication.run(MemeApp.class, args);
    System.out.println("Congratulations! your server is running");
  }

  @Bean
  @Scope("prototype")
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
