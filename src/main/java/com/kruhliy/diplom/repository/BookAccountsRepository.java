package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.BookAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookAccountsRepository extends CrudRepository<BookAccounts, Long> {

    List<BookAccounts> findAllByKsSAndKsDataBetween(Integer ksS, Date nstDatas, Date nstDatad);

    @Query(nativeQuery = true, value = "SELECT kvvj_ks.kvvj_ks_s AS s, kvvj_ks.kvvj_ks_ks AS ks, SUM(kvvj_ks.kvvj_ks_db) AS db " +
            "FROM kvvj_ks " +
            "WHERE kvvj_ks.kvvj_ks_s = ?1 AND kvvj_ks.kvvj_ks_data BETWEEN ?2 AND ?3 " +
            "GROUP BY ks " +
            "ORDER BY db DESC")
    String[][] findBalanceSheet(Integer ksS, Date nstDatas, Date nstDatad);

    @Query(nativeQuery = true, value = "SELECT kvvj_ks.kvvj_ks_s AS s, kvvj_ks.kvvj_ks_ks AS ks, SUM(kvvj_ks.kvvj_ks_kr) AS kr " +
            "FROM kvvj_ks " +
            "WHERE kvvj_ks.kvvj_ks_s = ?1 AND kvvj_ks.kvvj_ks_data BETWEEN ?2 AND ?3 " +
            "GROUP BY ks " +
            "ORDER BY kr DESC")
    String[][] findOrderLog(Integer ksS, Date nstDatas, Date nstDatad);
}
