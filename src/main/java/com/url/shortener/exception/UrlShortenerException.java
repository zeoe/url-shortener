/* (C)2023 */
package com.url.shortener.exception;

import java.text.MessageFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UrlShortenerException extends RuntimeException {
  private final String id;
  private final HttpStatus httpStatus;
  private final String message;

  public UrlShortenerException(UrlShortenerErrorCode errorCode, Object... values) {
    id = errorCode.getId();
    httpStatus = errorCode.getHttpStatus();
    message = MessageFormat.format(errorCode.getMessage(), values);
  }
}
