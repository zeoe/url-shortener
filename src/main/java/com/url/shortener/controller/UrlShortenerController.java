/* (C)2023 */
package com.url.shortener.controller;

import com.url.shortener.controller.model.UrlShortenerRequestDto;
import com.url.shortener.controller.model.UrlShortenerResponseDto;
import com.url.shortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/urls/")
public class UrlShortenerController {

  private final UrlShortenerService urlShortenerService;

  @PostMapping("/shorten")
  public UrlShortenerResponseDto shorten(
      @RequestBody @Validated UrlShortenerRequestDto urlShortenerRequestDto) {
    return urlShortenerService.shorten(urlShortenerRequestDto);
  }

  @GetMapping("/origins/{id}")
  public UrlShortenerResponseDto findOriginById(@PathVariable String id) {
    return urlShortenerService.findOriginById(id);
  }
}
