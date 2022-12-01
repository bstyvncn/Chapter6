package org.binar.chapter4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.chapter4.model.film;
import org.binar.chapter4.model.response.scheduleResponse;
import org.binar.chapter4.model.schedule;
import org.binar.chapter4.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/schedule")
public class scheduleController {
    @Autowired
    IScheduleService scheduleService;
    //5. Menampilkan jadwal dari film tertentu (POST)

    @Operation(summary = "untuk menampilkan jadwal film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = scheduleResponse.class))})
    })
    @PostMapping("/public/show-schedule")
    public ResponseEntity viewSchedule(@RequestParam("film") film film) {

        schedule schedule = (org.binar.chapter4.model.schedule) scheduleService.viewSchedule(film);
        scheduleResponse resp = new scheduleResponse(schedule.getScheduleID(), schedule.getTanggalTayang(), schedule.getJamMulai(),
                schedule.getJamSelesai(), schedule.getHargaTiket(), schedule.getNamaStudio());

        try {
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> respgagal = new HashMap<>();
            respgagal.put("message", "fetch data gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(respgagal, HttpStatus.BAD_GATEWAY);
        }
    }
}
