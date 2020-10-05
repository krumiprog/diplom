package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.TypesAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesAnalyticsRepository extends JpaRepository<TypesAnalytics, Long> {
}
