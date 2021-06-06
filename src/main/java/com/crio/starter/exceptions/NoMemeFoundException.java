package com.crio.starter.exceptions;

public class NoMemeFoundException extends RuntimeException {

    
  private static final long serialVersionUID = 1L;

  public NoMemeFoundException() {
  }
    
  public NoMemeFoundException(String message) {
    super(message);
  }
}