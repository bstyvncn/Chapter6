package org.binar.chapter4.model.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class scheduleRequest {
    private Integer scheduleID;
    private LocalDate tanggalTayang;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;
    private Integer hargaTiket;
    private String namaStudio;
    private org.binar.chapter4.model.film film;
}
