package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.TestSpring;
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
public class TestSpringRepositoryTest extends BaseRepositoryTest {

  @Autowired
  private TestSpringRepository repository;

  @Test
  void save_saves() {
    TestSpring test = TestSpring.mock();

    repository.save(test);
    Optional<TestSpring> result = repository.findByTestId(test.getTestId());

    assertThat(result).isEqualTo(Optional.of(test));
  }

  @Test
  void findByTextTest_findCorrectTests() {
    String textTest = UUID.randomUUID().toString();

    List<TestSpring> sameTexts = Stream.generate(() -> {
      TestSpring mock = TestSpring.mock();
      mock.setTextTest(textTest);
      return mock;
    })
        .limit(3)
        .collect(Collectors.toList());

    List<TestSpring> differentTexts = Stream.generate(TestSpring::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(sameTexts);
    repository.saveAll(differentTexts);

    List<TestSpring> result = repository.findByTextTest(textTest);
    assertThat(result).containsOnlyOnceElementsOf(sameTexts);
  }

  @Test
  public void findByNumberTest_findCorrectTests() {
    int numberTest = new Random().nextInt();

    List<TestSpring> sameNumbers = Stream.generate(() -> {
      TestSpring mock = TestSpring.mock();
      mock.setNumberTest(numberTest);
      return mock;
    })
        .limit(3)
        .collect(Collectors.toList());

    List<TestSpring> differentNumbers = Stream.generate(TestSpring::mock)
        .limit(3)
        .collect(Collectors.toList());

    repository.saveAll(sameNumbers);
    repository.saveAll(differentNumbers);

    List<TestSpring> result = repository.findByNumberTest(numberTest);
    assertThat(result).containsOnlyOnceElementsOf(sameNumbers);
  }

}
