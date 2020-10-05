package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.ChartAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartAccountsRepository extends JpaRepository<ChartAccounts, Long> {
}
