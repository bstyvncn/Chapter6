package org.binar.chapter4.model.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class scheduleResponse {
    private Integer scheduleID;
    private LocalDate tanggalTayang;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;
    private Integer hargaTiket;
    private String namaStudio;
    private org.binar.chapter4.model.film film;

    public scheduleResponse(Integer scheduleID, LocalDate tanggalTayang, LocalTime jamMulai, LocalTime jamSelesai, Integer hargaTiket, String namaStudio) {
        scheduleID = this.scheduleID;
        tanggalTayang = this.tanggalTayang;
        jamMulai = this.jamMulai;
        jamSelesai = this.jamSelesai;
        hargaTiket = this.hargaTiket;
        namaStudio = this.namaStudio;
    }
}
