/* (C)2023 */
package com.url.shortener.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UrlShortenerRequestDto(
    @NotEmpty @Size(max = 5000, message = "url may be a maximum of 5000 characters long")
        String url) {}
