package com.crio.starter.exceptions;

public class DuplicateMemeException extends RuntimeException {

  /**
     * Exception is thrown when duplicate memes are encountered.
     */
  private static final long serialVersionUID = 1L;

  public DuplicateMemeException() {
  }

  public DuplicateMemeException(String message) {
    super(message);
  }   
}