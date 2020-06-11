package com.shigotosagashi.jobdomainservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExampleEntity {

  @Id
  String testId;
  String textTest;
  int numberTest;
  long datetimeTest;

  public static ExampleEntity create(String testId,
                                     String textTest,
                                     int numberTest,
                                     long datetimeTest) {
    return ExampleEntity.builder()
        .testId(testId)
        .textTest(textTest)
        .numberTest(numberTest)
        .datetimeTest(datetimeTest)
        .build();
  }

  public static ExampleEntity mock() {
    return ExampleEntity.builder()
        .testId(UUID.randomUUID().toString())
        .textTest(new Random().nextBoolean() ? UUID.randomUUID().toString() : null)
        .numberTest(new Random().nextInt())
        .datetimeTest(Instant.now().toEpochMilli())
        .build();
  }
}