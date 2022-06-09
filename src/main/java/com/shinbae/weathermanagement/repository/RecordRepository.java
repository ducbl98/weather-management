package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
}
