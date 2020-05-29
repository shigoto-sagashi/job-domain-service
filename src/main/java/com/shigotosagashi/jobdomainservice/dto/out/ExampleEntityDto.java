package com.shigotosagashi.jobdomainservice.dto.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;

import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;

@JsonInclude(NON_ABSENT)
public class ExampleEntityDto {

  public final String testId;
  public final Optional<String> textTest;
  public final Integer numberTest;
  public final Long datetimeTest;

  public ExampleEntityDto(String testId,
                          Optional<String> textTest,
                          Integer numberTest,
                          Long datetimeTest) {
    this.testId = testId;
    this.textTest = textTest;
    this.numberTest = numberTest;
    this.datetimeTest = datetimeTest;
  }

  public static ExampleEntityDto fromEntity(ExampleEntity entity) {
    return new ExampleEntityDto(
        entity.getTestId(),
        Optional.ofNullable(entity.getTextTest()),
        entity.getNumberTest(),
        entity.getDatetimeTest()
    );
  }
}
