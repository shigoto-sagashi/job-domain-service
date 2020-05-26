package com.shigotosagashi.jobdomainservice.repository;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseRepositoryTest {

  @BeforeAll
  public static void init() {
    Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/test", "sa", null).load();
    flyway.migrate();
  }

}
