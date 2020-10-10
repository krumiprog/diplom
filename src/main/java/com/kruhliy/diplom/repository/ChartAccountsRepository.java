package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.ChartAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartAccountsRepository extends CrudRepository<ChartAccounts, Long> {
}
