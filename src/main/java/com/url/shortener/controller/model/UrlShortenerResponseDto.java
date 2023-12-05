/* (C)2023 */
package com.url.shortener.controller.model;

import lombok.Builder;

@Builder
public record UrlShortenerResponseDto(
    String shorten, String origin, String counter_shorten, String counter_usage) {}
