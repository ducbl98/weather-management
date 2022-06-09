package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.CoordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordRepository extends JpaRepository<CoordEntity, Long> {
}
