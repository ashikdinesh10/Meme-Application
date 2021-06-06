package com.crio.starter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document(collection = "memes")
@NoArgsConstructor
@JsonIgnoreProperties({"id"})
public class Meme {
    
  private String id;

  @NotNull
  private String name;

  @NotNull
  private String url;

  @NotNull
  private String caption;
}