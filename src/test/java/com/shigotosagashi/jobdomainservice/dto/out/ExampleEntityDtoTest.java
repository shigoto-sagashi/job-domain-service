package com.shigotosagashi.jobdomainservice.dto.out;

import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleEntityDtoTest {

  @Test
  void fromEntity_transformsCorrectly() {
    ExampleEntity entity = ExampleEntity.mock();
    ExampleEntityDto result = ExampleEntityDto.fromEntity(entity);

    assertThat(result.testId).isEqualTo(entity.getTestId());
    assertThat(result.textTest).isEqualTo(Optional.ofNullable(entity.getTextTest()));
    assertThat(result.numberTest).isEqualTo(entity.getNumberTest());
    assertThat(result.datetimeTest).isEqualTo(entity.getDatetimeTest());
  }

}
