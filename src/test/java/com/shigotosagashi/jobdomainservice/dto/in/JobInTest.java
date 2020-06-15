package com.shigotosagashi.jobdomainservice.dto.in;

import com.shigotosagashi.jobdomainservice.domain.JobEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class JobInTest {

  @Test
  void toEntity_transformsCorrectly() {
    JobIn jobIn = JobIn.mock();
    JobEntity result = jobIn.toEntity();

    assertThat(result.getId()).isNotNull();
    assertThat(result.getTitle()).isEqualTo(jobIn.title);
    assertThat(result.getDescription()).isEqualTo(jobIn.description);
    assertThat(result.getCreationDate()).isNotNull();
    assertThat(result.getExpirationDate()).isEqualTo(jobIn.expirationDate);
  }

  @Test
  void toEntity_whenIdIsInformed_transformsCorrectly() {
    String id = UUID.randomUUID().toString();
    JobIn jobIn = JobIn.mock();
    JobEntity result = jobIn.toEntity(id);

    assertThat(result.getId()).isEqualTo(id);
    assertThat(result.getTitle()).isEqualTo(jobIn.title);
    assertThat(result.getDescription()).isEqualTo(jobIn.description);
    assertThat(result.getExpirationDate()).isEqualTo(jobIn.expirationDate);
  }
}
