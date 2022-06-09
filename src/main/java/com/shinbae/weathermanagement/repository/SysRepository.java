package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.SysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRepository extends JpaRepository<SysEntity, Long> {
}
