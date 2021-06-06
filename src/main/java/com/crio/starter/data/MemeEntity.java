package com.crio.starter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "greetings")
@NoArgsConstructor
@AllArgsConstructor
public class MemeEntity {


  @Transient
  public static final String SEQUENCE_NAME = "user_sequence";

  @Id
  private long id;

  private String name;

  private String url;

  private String caption;

}
