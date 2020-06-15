package com.shigotosagashi.jobdomainservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JobEntity {

  @Id
  String id;
  String title;
  String description;
  long creationDate;
  long expirationDate;

  public static JobEntity create(String id,
                                 String title,
                                 String description,
                                 long creationDate,
                                 long expirationDate) {
    return JobEntity.builder()
        .id(id)
        .title(title)
        .description(description)
        .creationDate(creationDate)
        .expirationDate(expirationDate)
        .build();
  }

  public static JobEntity mock() {
    return JobEntity.builder()
        .id(UUID.randomUUID().toString())
        .title(UUID.randomUUID().toString())
        .description(UUID.randomUUID().toString())
        .creationDate(Instant.now().toEpochMilli())
        .expirationDate(Instant.now().toEpochMilli())
        .build();
  }
}
