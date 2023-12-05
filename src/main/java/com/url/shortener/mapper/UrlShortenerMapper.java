/* (C)2023 */
package com.url.shortener.mapper;

import com.url.shortener.controller.model.UrlShortenerResponseDto;
import com.url.shortener.database.model.MappingDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Value;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class UrlShortenerMapper {

  @Value("${url.shorten.hostname}")
  protected String urlShortenHostname;

  @Mapping(target = "shorten", source = "id", qualifiedByName = "convertToUrl")
  public abstract UrlShortenerResponseDto toUrlShortenerRequestDto(MappingDocument mappingDocument);

  @Named("convertToUrl")
  String convertToUrl(String id) {
    return urlShortenHostname + "/" + id;
  }
}
