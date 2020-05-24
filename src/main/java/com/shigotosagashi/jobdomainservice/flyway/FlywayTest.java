package com.shigotosagashi.jobdomainservice.flyway;

import org.flywaydb.core.Flyway;

public class FlywayTest {

  public static void main(String[] args) {
    Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/test", "sa", null).load();

    flyway.migrate();
  }

}
