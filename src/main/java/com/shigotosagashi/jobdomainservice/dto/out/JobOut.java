package com.shigotosagashi.jobdomainservice.dto.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shigotosagashi.jobdomainservice.domain.JobEntity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;

@JsonInclude(NON_ABSENT)
public class JobOut {

  public final String id;
  public final String title;
  public final String description;
  public final Long creationDate;
  public final Long expirationDate;

  public JobOut(String id,
                String title,
                String description,
                Long creationDate,
                Long expirationDate) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.expirationDate = expirationDate;
  }

  public static JobOut fromEntity(JobEntity jobEntity) {
    return new JobOut(
        jobEntity.getId(),
        jobEntity.getTitle(),
        jobEntity.getDescription(),
        jobEntity.getCreationDate(),
        jobEntity.getExpirationDate()
    );
  }
}
