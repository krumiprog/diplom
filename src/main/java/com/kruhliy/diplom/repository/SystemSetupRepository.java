package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.SystemSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSetupRepository extends JpaRepository<SystemSetup, Long> {
}
