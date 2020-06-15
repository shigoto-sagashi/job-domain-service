package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.JobEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobEntityRepository extends CrudRepository<JobEntity, String> {

  List<JobEntity> findByTitleContaining(String title);
  List<JobEntity> findByDescriptionContaining(String description);
  List<JobEntity> findByExpirationDateAfter(long datetime);
}
