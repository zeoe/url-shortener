/* (C)2023 */
package com.url.shortener.database.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("mapping")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MappingDocument {
  private @Id String id;
  private String origin;
  private int counter_shorten;
  private int counter_usage;
}
