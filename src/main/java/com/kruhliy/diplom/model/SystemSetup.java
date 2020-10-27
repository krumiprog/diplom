package com.kruhliy.diplom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/***
 * kvvj_nst Настройки
 */
@Entity
@Table(name = "kvvj_nst")
@Getter
@Setter
@NoArgsConstructor
public class SystemSetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_nst_0")
    private Long id;

    // дата текущая (d)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_nst_datat")
    private Date nstDatat;

    // интервал с (d)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_nst_datas")
    private Date nstDatas;

    // интервал до (d)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_nst_datad")
    private Date nstDatad;

    // cчёт (n2)
    @Column(name = "kvvj_nst_s")
    private Integer nstS;

    // название счёта (c10)
    @Column(name = "kvvj_nst_sn")
    private String nstSn;

    // название фирмы (c10)
    @Column(name = "kvvj_nst_firma")
    private String nstFirma;
}

