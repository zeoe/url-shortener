/* (C)2023 */
package com.url.shortener.service;

import com.google.common.hash.Hashing;
import com.url.shortener.controller.model.UrlShortenerRequestDto;
import com.url.shortener.controller.model.UrlShortenerResponseDto;
import com.url.shortener.controller.model.UsageType;
import com.url.shortener.database.model.MappingDocument;
import com.url.shortener.exception.UrlShortenerErrorCode;
import com.url.shortener.exception.UrlShortenerException;
import com.url.shortener.mapper.UrlShortenerMapper;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

  private final MappingService mappingService;
  private final UrlShortenerMapper urlShortenerMapper;

  public UrlShortenerResponseDto shorten(UrlShortenerRequestDto urlShortenerRequestDto) {
    String id = generateShortHashId(urlShortenerRequestDto);

    return urlShortenerMapper.toUrlShortenerRequestDto(
        mappingService.createOrUpdate(id, urlShortenerRequestDto.url(), UsageType.SHORTEN));
  }

  public UrlShortenerResponseDto findOriginById(String id) {
    MappingDocument mappingDocument =
        mappingService
            .findById(id)
            .orElseThrow(() -> new UrlShortenerException(UrlShortenerErrorCode.ID_NOT_FOUND, id));

    return urlShortenerMapper.toUrlShortenerRequestDto(
        mappingService.update(mappingDocument, UsageType.CALL));
  }

  private String generateShortHashId(UrlShortenerRequestDto urlShortenerRequestDto) {
    return Hashing.murmur3_32_fixed()
        .hashString(urlShortenerRequestDto.url(), StandardCharsets.UTF_8)
        .toString();
  }
}
