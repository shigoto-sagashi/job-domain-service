package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.TestSpring;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestSpringRepository extends CrudRepository<TestSpring, String> {

  Optional<TestSpring> findByTestId(String testId);

  List<TestSpring> findByTextTest(String textTest);

  List<TestSpring> findByNumberTest(int numberTest);

}
