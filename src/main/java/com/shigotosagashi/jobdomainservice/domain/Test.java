package com.shigotosagashi.jobdomainservice.domain;

import com.google.auto.value.AutoValue;

import java.util.Optional;

@AutoValue
public abstract class Test {

  public abstract String testId();

  public abstract Optional<String> testName();

  public abstract int testNumber();

  public static Test create(String testId, Optional<String> testName, int testNumber) {
    return builder()
        .testId(testId)
        .testName(testName)
        .testNumber(testNumber)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_Test.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder testId(String testId);

    public abstract Builder testName(Optional<String> testName);

    public abstract Builder testNumber(int testNumber);

    public abstract Test build();
  }
}
