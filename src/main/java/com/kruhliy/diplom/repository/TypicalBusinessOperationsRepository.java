package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.TypicalBusinessOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypicalBusinessOperationsRepository extends CrudRepository<TypicalBusinessOperations, Long> {
}
