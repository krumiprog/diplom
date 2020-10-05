package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/***
 * kvvj_opd Определение первычных документов (ОПД)
 */
@Entity
@Table(name = "kvvj_opd")
@Getter
@Setter
@NoArgsConstructor
public class DefiningPrimaryDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_opd_0")
    private Long id;

    // код документа (c3)
    @Column(name = "kvvj_opd_k")
    private String opdK;

    // наименование документа (c10)
    @Column(name = "kvvj_opd_n")
    private String opdN;

    // вид аналитики 1 < --- va (c3)
    @Column(name = "kvvj_opd_av1")
    private String opdAv1;

    // тип аналитики 1 = д, к, x (c1)
    @Column(name = "kvvj_opd_avt1")
    private String opdAvt1;

    // виды аналитики 2 (c3)
    @Column(name = "kvvj_opd_av2")
    private String opdAv2;

    // тип аналитики 2 (c1)
    @Column(name = "kvvj_opd_avt2")
    private String opdAvt2;

    // вид аналитики 3 (c3)
    @Column(name = "kvvj_opd_av3")
    private String opdAv3;

    // тип аналитики 3 (c1)
    @Column(name = "kvvj_opd_avt3")
    private String opdAvt3;
}
