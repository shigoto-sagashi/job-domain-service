package com.shigotosagashi.jobdomainservice.controller;

import com.shigotosagashi.jobdomainservice.dto.out.ExampleEntityDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/job")
public class JobController {

  @PostMapping("/save")
  public ExampleEntityDto save(
      @Valid @RequestBody com.shigotosagashi.jobdomainservice.dto.in.ExampleEntityDto example) {

    return new ExampleEntityDto(
        UUID.randomUUID().toString(),
        example.textTest,
        example.numberTest
    );
  }

  @GetMapping("/find/{id}")
  public ExampleEntityDto findById(@PathVariable String id) {
    return new ExampleEntityDto(
        id,
        new Random().nextBoolean() ? Optional.of("FOUND_EXT") : Optional.empty(),
        new Random().nextInt()
    );
  }
}
