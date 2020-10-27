package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/***
 * kvvj_pd Первичные документы (КПД)
 */
@Entity
@Table(name = "kvvj_pd")
@Getter
@Setter
@NoArgsConstructor
public class PrimaryDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_pd_0")
    private Long id;

    // код документа < --- opd (c3)
    @Column(name = "kvvj_pd_dokk")
    private String pdDokk;

    // номер документа (n5)
    @Column(name = "kvvj_pd_dokn")
    private Integer pdDokn;

    // дата документа (d)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_pd_dokd")
    private Date pdDokd;

    // вид аналитики 1 * opd (c3)
    @Column(name = "kvvj_pd_av1")
    private String pdAv1;

    // тип аналитики 1 = д, к, x (c1)
    @Column(name = "kvvj_pd_avt1")
    private String pdAvt1;

    // аналитика код 1 < --- kau (c10)
    @Column(name = "kvvj_pd_ak1")
    private String pdAk1;

    // вид аналитики 2 (c3)
    @Column(name = "kvvj_pd_av2")
    private String pdAv2;

    // тип аналитики 2 (c1)
    @Column(name = "kvvj_pd_avt2")
    private String pdAvt2;

    // аналитика код 2 (c10)
    @Column(name = "kvvj_pd_ak2")
    private String pdAk2;

    // вид аналитики 3 (c3)
    @Column(name = "kvvj_pd_av3")
    private String pdAv3;

    // тип аналитики 3 (c1)
    @Column(name = "kvvj_pd_avt3")
    private String pdAvt3;

    // аналитика код 3 (c10)
    @Column(name = "kvvj_pd_ak3")
    private String pdAk3;

    // операция (c10)
    @Column(name = "kvvj_pd_to")
    private String pdTo;

    // дебет счет * txo (n2)
    @Column(name = "kvvj_pd_db")
    private Integer pdDb;

    // дебет наименование * txo (c10)
    @Column(name = "kvvj_pd_dbn")
    private String pdDbn;

    // кредит * txo (n2)
    @Column(name = "kvvj_pd_kr")
    private Integer pdKr;

    // кредит название * txo (c10)
    @Column(name = "kvvj_pd_krn")
    private String pdKrn;

    // сумма (n8)
    @Column(name = "kvvj_pd_rub")
    private Integer pdRub;
}
