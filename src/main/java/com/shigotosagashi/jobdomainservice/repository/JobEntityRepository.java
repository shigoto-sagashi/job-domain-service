package com.shigotosagashi.jobdomainservice.repository;

import com.shigotosagashi.jobdomainservice.domain.JobEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobEntityRepository extends CrudRepository<JobEntity, String> {

  List<JobEntity> findByTitleLike(String title);
  List<JobEntity> findByDescriptionLike(String description);
  List<JobEntity> findByExpirationDateAfter(long datetime);
}
