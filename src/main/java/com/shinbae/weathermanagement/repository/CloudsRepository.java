package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.CloudsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudsRepository extends JpaRepository<CloudsEntity, Long> {
}
