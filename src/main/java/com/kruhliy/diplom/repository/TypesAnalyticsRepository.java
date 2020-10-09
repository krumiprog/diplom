package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.TypesAnalytics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypesAnalyticsRepository extends CrudRepository<TypesAnalytics, Long> {
    Optional<TypesAnalytics> findByVaK(String vaK);
}
