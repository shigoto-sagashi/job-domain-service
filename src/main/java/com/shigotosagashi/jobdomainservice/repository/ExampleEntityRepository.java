package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExampleEntityRepository extends CrudRepository<ExampleEntity, String> {

  Optional<ExampleEntity> findByTestId(String testId);

  List<ExampleEntity> findByTextTest(String textTest);

  List<ExampleEntity> findByNumberTest(int numberTest);
}
