package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<MainEntity, Long> {
}
