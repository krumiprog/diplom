package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.AnalyticalAccountingCodes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnalyticalAccountingCodesRepository extends CrudRepository<AnalyticalAccountingCodes, Long> {
    Optional<AnalyticalAccountingCodes> findByKauNAndKauK(String kauN, String kauK);
}
