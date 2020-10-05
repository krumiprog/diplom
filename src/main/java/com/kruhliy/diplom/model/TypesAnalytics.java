package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/***
 * kvvj_va Виды аналитики
 */
@Entity
@Table(name = "kvvj_va")
@Getter
@Setter
@NoArgsConstructor
public class TypesAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_va_0")
    private Long id;

    // вид аналитики (c3)
    @Column(name = "kvvj_va_k")
    private String vaK;

    // название вида аналитики (c15)
    @Column(name = "kvvj_va_n")
    private String vaN;
}
