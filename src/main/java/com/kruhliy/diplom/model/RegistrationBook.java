package com.kruhliy.diplom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/***
 * kvvj_rj Регистрационный журнал (РЖ)
 */
@Entity
@Table(name = "kvvj_rj")
@Getter
@Setter
@NoArgsConstructor
public class RegistrationBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kvvj_rj_0")
    private Long id;

    // дата операции (d)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_rj_data")
    private Date rjData;

    // код оправдательного документа (c3)
    @Column(name = "kvvj_rj_dokk")
    private String rjDokk;

    // номер документа (n5)
    @Column(name = "kvvj_rj_dokn")
    private Integer rjDokn;

    // дата документа (d)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "kvvj_rj_dokd")
    private Date rjDokd;

    // содержание операции (c10)
    @Column(name = "kvvj_rj_to")
    private String rjTo;

    // дебет, счет (n2)
    @Column(name = "kvvj_rj_db")
    private Integer rjDb;

    // дебет, название (c10)
    @Column(name = "kvvj_rj_dbn")
    private String rjDbn;

    // кредит, счет (n2)
    @Column(name = "kvvj_rj_kr")
    private Integer rjKr;

    // кредит название (c10)
    @Column(name = "kvvj_rj_krn")
    private String rjKrn;

    // Сумма (n10)
    @Column(name = "kvvj_rj_rub")
    private Integer rjRub;

    @Override
    public String toString() {
        return "RegistrationBook{" +
                "id=" + id +
                ", rjData=" + rjData +
                ", rjDokk='" + rjDokk + '\'' +
                ", rjDokn=" + rjDokn +
                ", rjDokd=" + rjDokd +
                ", rjTo='" + rjTo + '\'' +
                ", rjDb=" + rjDb +
                ", rjDbn='" + rjDbn + '\'' +
                ", rjKr=" + rjKr +
                ", rjKrn='" + rjKrn + '\'' +
                ", rjRub=" + rjRub +
                '}';
    }
}
