package com.shigotosagashi.jobdomainservice.dto.in;

import com.shigotosagashi.jobdomainservice.domain.ExampleEntity;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleEntityDtoTest {

  @Test
  void toEntity_transformsCorrectly() {
    ExampleEntityDto dto = ExampleEntityDto.mock();
    ExampleEntity result = dto.toEntity();

    assertThat(result.getTestId()).isNotNull();
    assertThat(dto.textTest).isEqualTo(Optional.ofNullable(result.getTextTest()));
    assertThat(dto.numberTest).isEqualTo(result.getNumberTest());
  }


}
