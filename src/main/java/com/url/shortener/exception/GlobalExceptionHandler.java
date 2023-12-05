/* (C)2023 */
package com.url.shortener.exception;

import com.url.shortener.controller.model.ResponseErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(UrlShortenerException.class)
  public ResponseEntity<ResponseErrorDto> handleDemoException(
      UrlShortenerException urlShortenerException) {
    log.error(
        "Exception occurred - class {} line {}: {}",
        urlShortenerException.getStackTrace()[0].getFileName(),
        urlShortenerException.getStackTrace()[0].getLineNumber(),
        urlShortenerException.getMessage());

    return ResponseEntity.status(urlShortenerException.getHttpStatus())
        .body(
            ResponseErrorDto.builder()
                .id(urlShortenerException.getId())
                .message(urlShortenerException.getMessage())
                .build());
  }
}
