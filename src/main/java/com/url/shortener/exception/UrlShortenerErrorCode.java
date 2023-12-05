/* (C)2023 */
package com.url.shortener.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum UrlShortenerErrorCode {
  ID_NOT_FOUND("1", HttpStatus.NOT_FOUND, "id not found for {0}");

  private final String id;
  private final HttpStatus httpStatus;
  private final String message;

  UrlShortenerErrorCode(String id, HttpStatus httpStatus, String message) {
    this.id = id;
    this.httpStatus = httpStatus;
    this.message = message;
  }
}
