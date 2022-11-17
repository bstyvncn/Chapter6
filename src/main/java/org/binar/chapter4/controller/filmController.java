package org.binar.chapter4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.chapter4.model.film;
import org.binar.chapter4.model.request.filmRequest;
import org.binar.chapter4.model.response.filmResponse;
import org.binar.chapter4.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@Controller
@RestController
@RequestMapping("/film")
public class filmController {
    @Autowired
    IFilmService filmService;
//    1. Menambahkan film baru (POST)

    @Operation(summary = "untuk menambahkan film baru ke dalam sistem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = filmResponse.class))})
    })
    @PostMapping(value = "/new_film")
    public ResponseEntity newFilm(@RequestParam("namaFilm") String namaFilm, @RequestParam("statusTayang") String statusTayang) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "insert success!");

        try {
            film film = new film();
            film.setNamaFilm(namaFilm);
            film.setStatusTayang(statusTayang);
            filmService.newFilm(film);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "insert gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }

    //2. Mengupdate nama film (PUT)
    @Operation(summary = "untuk update film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = filmResponse.class))})
    })
    @PutMapping(value = "/update_film")
    public ResponseEntity updateFilm(@RequestParam("NameFrom") String from, @RequestParam("NameTo") String to) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "update success!");

        try {
            filmService.updateFilm(from, to);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "update gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }
//3. Menghapus film (DELETE)
    @Operation(summary = "untuk delete film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = filmResponse.class))})
    })
    @PutMapping(value = "/delete_film")
    public ResponseEntity deleteFilm(@Valid @RequestBody filmRequest filmRequest, @RequestParam("film") film film) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "delete success!");

        try {
            filmService.deleteFilm(film);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "insert gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }
//4. Menampilkan film yang sedang tayang (GET)
    @Operation(summary = "untuk show film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = filmResponse.class))})
    })
    @GetMapping(value = "/update_film")
    public ResponseEntity showFilm() {
        Map<String, Object> respgagal = new HashMap<>();

        film film = (org.binar.chapter4.model.film) filmService.showFilm();
        filmResponse resp = new filmResponse(film.getNamaFilm());

        try {
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e) {
            respgagal.put("message", "show film gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }
}
