package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.WindEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindRepository extends JpaRepository<WindEntity, Long> {
}
