package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.SystemSetup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSetupRepository extends CrudRepository<SystemSetup, Long> {
}
