package com.shigotosagashi.jobdomainservice.dto.in;

import com.shigotosagashi.jobdomainservice.domain.JobEntity;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class JobIn {
  @NotNull(message = "Missing required field title")
  public final String title;
  @NotNull(message = "Missing required field description")
  public final String description;
  public final Optional<Long> creationDate;
  @NotNull(message = "Missing required field expirationDate")
  public final long expirationDate;

  public JobIn(String title, String description, Optional<Long> creationDate, long expirationDate) {
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.expirationDate = expirationDate;
  }

  public JobEntity toEntity() {
    return toEntity(UUID.randomUUID().toString());
  }

  public JobEntity toEntity(String id) {
    return JobEntity.create(
        id,
        title,
        description,
        creationDate.orElse(Instant.now().toEpochMilli()),
        expirationDate
    );
  }

  public static JobIn mock() {
    return new JobIn(
        UUID.randomUUID().toString(),
        UUID.randomUUID().toString(),
        Optional.of(Instant.now().toEpochMilli()),
        Instant.now().toEpochMilli() + new Random().nextLong()
    );
  }
}
