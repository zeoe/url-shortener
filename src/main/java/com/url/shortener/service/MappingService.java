/* (C)2023 */
package com.url.shortener.service;

import com.url.shortener.controller.model.UsageType;
import com.url.shortener.database.MappingRepository;
import com.url.shortener.database.model.MappingDocument;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MappingService {

  private final MappingRepository mappingRepository;

  public MappingDocument createOrUpdate(String id, String origin, UsageType usageType) {
    Optional<MappingDocument> mappingDocumentOptional = findById(id);

    if (mappingDocumentOptional.isEmpty()) {
      return create(id, origin);
    } else {
      return update(mappingDocumentOptional.get(), usageType);
    }
  }

  public MappingDocument update(MappingDocument mappingDocument, UsageType usageType) {
    if (UsageType.SHORTEN.equals(usageType)) {
      mappingDocument.setCounter_shorten(mappingDocument.getCounter_shorten() + 1);
    }

    if (UsageType.CALL.equals(usageType)) {
      mappingDocument.setCounter_usage(mappingDocument.getCounter_usage() + 1);
    }

    return mappingRepository.save(mappingDocument);
  }

  public Optional<MappingDocument> findById(String id) {
    return mappingRepository.findById(id);
  }

  private MappingDocument create(String id, String origin) {
    return mappingRepository.save(
        MappingDocument.builder()
            .id(id)
            .origin(origin)
            .counter_shorten(1)
            .counter_usage(0)
            .build());
  }
}
