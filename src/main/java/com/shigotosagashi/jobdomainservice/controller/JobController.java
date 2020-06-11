package com.shigotosagashi.jobdomainservice.controller;

import com.shigotosagashi.jobdomainservice.dto.in.JobIn;
import com.shigotosagashi.jobdomainservice.dto.out.JobOut;
import com.shigotosagashi.jobdomainservice.repository.JobEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

  @Autowired
  private JobEntityRepository jobEntityRepository;

  @PostMapping("/save")
  public JobOut save(
      @Valid @RequestBody JobIn example) {
    return JobOut.fromEntity(jobEntityRepository.save(example.toEntity()));
  }

  @PutMapping("/update/{id}")
  public JobOut update(
      @PathVariable String id,
      @Valid @RequestBody JobIn example) {
    return JobOut.fromEntity(jobEntityRepository.save(example.toEntity(id)));
  }

  @GetMapping("/find/{id}")
  public JobOut findById(
      @PathVariable String id) {
    return jobEntityRepository.findById(id)
        .map(JobOut::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("Job not found for id: " + id));
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable String id) {
    jobEntityRepository.deleteById(id);
  }
}
