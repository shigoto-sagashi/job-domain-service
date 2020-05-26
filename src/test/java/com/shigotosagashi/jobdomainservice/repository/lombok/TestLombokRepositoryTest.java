package com.shigotosagashi.jobdomainservice.repository.lombok;

import com.shigotosagashi.jobdomainservice.domain.lombok.TestLombok;
import com.shigotosagashi.jobdomainservice.repository.BaseRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TestLombokRepositoryTest extends BaseRepositoryTest {

  @Autowired
  private TestLombokRepository repository;

  @Test
  void save_saves() {
    TestLombok test = TestLombok.mock();

    repository.save(test);
    Optional<TestLombok> result = repository.findByTestId(test.getTestId());

    assertThat(result).isEqualTo(Optional.of(test));
  }

  @Test
  void findByTextTest_findCorrectTests() {
    String textTest = UUID.randomUUID().toString();

    List<TestLombok> sameTexts = Stream.generate(() -> TestLombok.mock()
        .toBuilder()
        .textTest(textTest)
        .build()
    )
        .limit(3)
        .collect(Collectors.toList());

    List<TestLombok> differentTexts = Stream.generate(TestLombok::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(sameTexts);
    repository.saveAll(differentTexts);

    List<TestLombok> result = repository.findByTextTest(textTest);
    assertThat(result).containsOnlyOnceElementsOf(sameTexts);
  }

  @Test
  public void findByNumberTest_findCorrectTests() {
    int numberTest = new Random().nextInt();

    List<TestLombok> sameNumbers = Stream.generate(() -> TestLombok.mock()
        .toBuilder()
        .numberTest(numberTest)
        .build()
    )
        .limit(3)
        .collect(Collectors.toList());

    List<TestLombok> differentNumbers = Stream.generate(TestLombok::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(sameNumbers);
    repository.saveAll(differentNumbers);

    List<TestLombok> result = repository.findByNumberTest(numberTest);
    assertThat(result).containsOnlyOnceElementsOf(sameNumbers);
  }

}
