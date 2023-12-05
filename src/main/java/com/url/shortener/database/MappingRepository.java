/* (C)2023 */
package com.url.shortener.database;

import com.url.shortener.database.model.MappingDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MappingRepository extends MongoRepository<MappingDocument, String> {}
