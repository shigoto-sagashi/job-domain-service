package com.shigotosagashi.jobdomainservice.dto.out;

import com.shigotosagashi.jobdomainservice.domain.JobEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class JobOutTest {

  @Test
  void fromEntity_transformsCorrectly() {
    JobEntity jobEntity = JobEntity.mock();
    JobOut result = JobOut.fromEntity(jobEntity);

    Assertions.assertThat(result.id).isEqualTo(jobEntity.getId());
    Assertions.assertThat(result.title).isEqualTo(jobEntity.getTitle());
    Assertions.assertThat(result.description).isEqualTo(jobEntity.getDescription());
    Assertions.assertThat(result.creationDate).isEqualTo(jobEntity.getCreationDate());
    Assertions.assertThat(result.expirationDate).isEqualTo(jobEntity.getExpirationDate());
  }
}