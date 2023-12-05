/* (C)2023 */
package com.url.shortener.controller.model;

import lombok.Builder;

@Builder
public record ResponseErrorDto(String id, String message) {}
