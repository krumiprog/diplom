package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.BookAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAccountsRepository extends CrudRepository<BookAccounts, Long> {
}
