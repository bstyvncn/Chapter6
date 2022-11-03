package org.binar.chapter4.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
public class schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleID;
    private LocalDate tanggalTayang;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;
    private Integer hargaTiket;
    private String namaStudio;

    @OneToOne
    private film film;
}
