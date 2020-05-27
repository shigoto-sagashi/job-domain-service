package com.shigotosagashi.jobdomainservice.dto.in;

import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class ExampleEntityDto {

  public final Optional<String> textTest;
  @NotNull(message = "Missing required field numberTest")
  public final Integer numberTest;

  public ExampleEntityDto(Optional<String> textTest, Integer numberTest) {
    this.textTest = textTest;
    this.numberTest = numberTest;
  }

  public ExampleEntity toEntity() {
    return ExampleEntity.create(
        UUID.randomUUID().toString(),
        textTest.orElse(null),
        numberTest
    );
  }

  public static ExampleEntityDto mock() {
    return new ExampleEntityDto(
        new Random().nextBoolean() ? Optional.of(UUID.randomUUID().toString()) : Optional.empty(),
        new Random().nextInt()
    );
  }
}
