package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.AnalyticalAccountingCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticalAccountingCodesRepository extends JpaRepository<AnalyticalAccountingCodes, Long> {
}
