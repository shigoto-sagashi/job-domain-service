package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExampleEntityRepository extends CrudRepository<ExampleEntity, String> {

  List<ExampleEntity> findByTextTest(String textTest);

  List<ExampleEntity> findByNumberTest(int numberTest);
}
