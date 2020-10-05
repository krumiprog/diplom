package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/***
 * kvvj_txo Типовые хозяйственные операции (ТХО)
 */
@Entity
@Table(name = "kvvj_txo")
@Getter
@Setter
@NoArgsConstructor
public class TypicalBusinessOperations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_txo_0")
    private Long id;

    // код документа < --- opd (c3)
    @Column(name = "kvvj_txo_dokk")
    private String txoDokk;

    // Операции (c10)
    @Column(name = "kvvj_txo_k")
    private String txoK;

    // дебет, счёт < --- ps_1 (n2)
    @Column(name = "kvvj_txo_db")
    private Integer txoDb;

    //дебет, название * ps_1 (c10)
    @Column(name = "kvvj_txo_dbn")
    private String txoDbn;

    // кредит < --- ps_2 (n2)
    @Column(name = "kvvj_txo_kr")
    private Integer txoKr;

    // кредит, название * ps_2 (c10)
    @Column(name = "kvvj_txo_krn")
    private String txoKrn;
}
