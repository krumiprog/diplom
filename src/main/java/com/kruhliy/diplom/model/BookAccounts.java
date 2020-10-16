package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/***
 * kvvj_ks Книга счетов (КС)
 */
@Entity
@Table(name = "kvvj_ks")
@Getter
@Setter
@NoArgsConstructor
public class BookAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_ks_0")
    private Long id;

    // дата операции
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_ks_data")
    private Date ksData;

    // код оправдательного документа
    @Column(name = "kvvj_ks_dokk")
    private String ksDokk;

    // номер документа
    @Column(name = "kvvj_ks_dokn")
    private Integer ksDokn;

    // дата документа
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_ks_dokd")
    private Date ksDokd;

    // операции
    @Column(name = "kvvj_ks_to")
    private String ksTo;

    // счет
    @Column(name = "kvvj_ks_s")
    private Integer ksS;

    // счёт название
    @Column(name = "kvvj_ks_sn")
    private String ksSn;

    // кор. счёт
    @Column(name = "kvvj_ks_ks")
    private Integer ksKs;

    // кор. счет наименование
    @Column(name = "kvvj_ks_ksn")
    private String ksKsn;

    // сумма дб
    @Column(name = "kvvj_ks_db")
    private Integer ksDb;

    // сумма кр
    @Column(name = "kvvj_ks_kr")
    private Integer ksKr;
}