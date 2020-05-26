package com.shigotosagashi.jobdomainservice.repository.lombok;

import com.shigotosagashi.jobdomainservice.domain.lombok.TestLombok;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestLombokRepository extends CrudRepository<TestLombok, String> {

  Optional<TestLombok> findByTestId(String testId);

  List<TestLombok> findByTextTest(String textTest);

  List<TestLombok> findByNumberTest(int numberTest);
}
