package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.BookAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAccountsRepository extends JpaRepository<BookAccounts, Long> {
}
