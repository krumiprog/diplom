package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.TypicalBusinessOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypicalBusinessOperationsRepository extends JpaRepository<TypicalBusinessOperations, Long> {
}
