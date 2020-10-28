package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.BookAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookAccountsRepository extends CrudRepository<BookAccounts, Long> {

//    List<BookAccounts> findByKsSAnd(Integer ksS, Date nstDatas, Date nstDatad);
}
