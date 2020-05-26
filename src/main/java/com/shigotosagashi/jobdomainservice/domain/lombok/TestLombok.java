package com.shigotosagashi.jobdomainservice.domain.lombok;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;
import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TestLombok {

  @Id
  @Builder.Default
  String testId = UUID.randomUUID().toString();

  @Builder.Default
  String textTest = new Random().nextBoolean() ? UUID.randomUUID().toString() : null;

  @Builder.Default
  int numberTest = new Random().nextInt();

  public static TestLombok mock() {
    return TestLombok.builder().build();
  }
}
