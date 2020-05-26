package com.shigotosagashi.jobdomainservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Entity
public class TestSpring {

  @Id
  private String testId;
  private String textTest;
  private int numberTest;

  public TestSpring() {
  }

  public TestSpring(String textTest, int numberTest) {
    this.testId = UUID.randomUUID().toString();
    this.textTest = textTest;
    this.numberTest = numberTest;
  }

  public static TestSpring mock() {
    return new TestSpring(
        new Random().nextBoolean() ? UUID.randomUUID().toString() : null,
        new Random().nextInt()
    );
  }

  public String getTestId() {
    return testId;
  }

  public String getTextTest() {
    return textTest;
  }

  public void setTextTest(String textTest) {
    this.textTest = textTest;
  }

  public int getNumberTest() {
    return numberTest;
  }

  public void setNumberTest(int numberTest) {
    this.numberTest = numberTest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TestSpring that = (TestSpring) o;
    return numberTest == that.numberTest &&
        Objects.equals(testId, that.testId) &&
        Objects.equals(textTest, that.textTest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(testId, textTest, numberTest);
  }
}
