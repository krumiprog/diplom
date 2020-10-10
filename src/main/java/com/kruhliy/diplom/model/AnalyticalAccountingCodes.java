package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/***
 * kvvj_kau Коды аналитического учета (КАУ)
 */
@Entity
@Table(name = "kvvj_kau")
@Getter
@Setter
@NoArgsConstructor
public class AnalyticalAccountingCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_kau_0")
    private Long id;

    // вид аналитики (c5)
    @Column(name = "kvvj_kau_n")
    private String kauN;

    // код аналитики (c15)
    @Column(name = "kvvj_kau_k")
    private String kauK;
}
