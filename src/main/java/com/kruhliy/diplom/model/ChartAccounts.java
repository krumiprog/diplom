package com.kruhliy.diplom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/***
 * kvvj_ps План счетов (ПС)
 */
@Entity
@Table(name = "kvvj_ps")
@Getter
@Setter
@NoArgsConstructor
public class ChartAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_ps_0")
    private Long id;

    // счет (n2)
    @Column(name = "kvvj_ps_s")
    private Integer psS;

    // название счета (c10)
    @Column(name = "kvvj_ps_n")
    private String psN;

    // тип счета = а, п, x (c1)
    @Column(name = "kvvj_ps_typ")
    private String psTyp;

    // вид аналитики 1 из VA (c3)
    @Column(name = "kvvj_ps_av1")
    private String psAv1;

    // вид аналитики 2 из VA (c3)
    @Column(name = "kvvj_ps_av2")
    private String psAv2;
}
