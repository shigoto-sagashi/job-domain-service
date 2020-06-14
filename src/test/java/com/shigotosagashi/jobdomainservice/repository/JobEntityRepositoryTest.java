package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.JobEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JobEntityRepositoryTest extends BaseRepositoryTest {

  @Autowired
  private JobEntityRepository repository;


  @Test
  void findByTitleLike_findsExpectedEntity() {
    String textTest = UUID.randomUUID().toString();

    List<JobEntity> jobsSameTitle = Stream.generate(() -> JobEntity.mock()
        .toBuilder()
        .title(textTest)
        .build())
        .limit(3)
        .collect(Collectors.toList());

    List<JobEntity> jobDifferentTitle = Stream.generate(JobEntity::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(jobsSameTitle);
    repository.saveAll(jobDifferentTitle);

    List<JobEntity> result = repository.findByTitleLike(textTest);
    assertThat(result).containsSequence(jobsSameTitle);
    assertThat(result).doesNotContainSequence(jobDifferentTitle);
  }

  @Test
  void findByDescriptionLike_findsExpectedEntity() {
    String textTest = UUID.randomUUID().toString();

    List<JobEntity> jobsSameDescription = Stream.generate(() -> JobEntity.mock()
        .toBuilder()
        .description(textTest)
        .build())
        .limit(3)
        .collect(Collectors.toList());

    List<JobEntity> jobDifferentDescription = Stream.generate(JobEntity::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(jobsSameDescription);
    repository.saveAll(jobDifferentDescription);

    List<JobEntity> result = repository.findByDescriptionLike(textTest);
    assertThat(result).containsSequence(jobsSameDescription);
    assertThat(result).doesNotContainSequence(jobDifferentDescription);
  }

  @Test
  void findByExpirationDateAfter_findsExpectedEntity() {
    long timeNow = Instant.now().toEpochMilli();
    long timeAfter = timeNow + new Random().nextInt(10000);
    long timeBefore = timeNow - new Random().nextInt(10000);

    List<JobEntity> jobExpirationDateAfter = Stream.generate(() -> JobEntity.mock()
        .toBuilder()
        .expirationDate(timeAfter)
        .build())
        .limit(3)
        .collect(Collectors.toList());

    List<JobEntity> jobExpirationDateBefore = Stream.generate(() -> JobEntity.mock()
        .toBuilder()
        .expirationDate(timeBefore)
        .build())
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(jobExpirationDateAfter);
    repository.saveAll(jobExpirationDateBefore);

    List<JobEntity> result = repository.findByExpirationDateAfter(timeNow);
    assertThat(result).containsSequence(jobExpirationDateAfter);
    assertThat(result).doesNotContainSequence(jobExpirationDateBefore);
  }
}
