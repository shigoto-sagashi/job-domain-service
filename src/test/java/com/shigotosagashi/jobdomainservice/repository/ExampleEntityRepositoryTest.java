package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ExampleEntityRepositoryTest extends BaseRepositoryTest {

  @Autowired
  private ExampleEntityRepository repository;

  @Test
  void save_savesExampleEntity() {
    ExampleEntity test = ExampleEntity.mock();

    repository.save(test);
    Optional<ExampleEntity> result = repository.findByTestId(test.getTestId());

    assertThat(result).isEqualTo(Optional.of(test));
  }

  @Test
  void findByTestId_findsExpectedEntity() {
    ExampleEntity test1 = ExampleEntity.mock();
    ExampleEntity test2 = ExampleEntity.mock();

    repository.saveAll(Arrays.asList(test1, test2));
    Optional<ExampleEntity> result = repository.findByTestId(test1.getTestId());

    assertThat(result).isEqualTo(Optional.of(test1));
  }

  @Test
  void findByTextTest_findsExpectedEntity() {
    String textTest = UUID.randomUUID().toString();

    List<ExampleEntity> sameTexts = Stream.generate(() -> ExampleEntity.mock()
        .toBuilder()
        .textTest(textTest)
        .build()
    )
        .limit(3)
        .collect(Collectors.toList());

    List<ExampleEntity> differentTexts = Stream.generate(ExampleEntity::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(sameTexts);
    repository.saveAll(differentTexts);

    List<ExampleEntity> result = repository.findByTextTest(textTest);
    assertThat(result).containsOnlyOnceElementsOf(sameTexts);
  }

  @Test
  public void findByNumberTest_findsExpectedEntity() {
    int numberTest = new Random().nextInt();

    List<ExampleEntity> sameNumbers = Stream.generate(() -> ExampleEntity.mock()
        .toBuilder()
        .numberTest(numberTest)
        .build()
    )
        .limit(3)
        .collect(Collectors.toList());

    List<ExampleEntity> differentNumbers = Stream.generate(ExampleEntity::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(sameNumbers);
    repository.saveAll(differentNumbers);

    List<ExampleEntity> result = repository.findByNumberTest(numberTest);
    assertThat(result).containsOnlyOnceElementsOf(sameNumbers);
  }

}