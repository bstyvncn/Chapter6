package org.binar.chapter4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.chapter4.model.bookFilm;
import org.binar.chapter4.model.request.userRequest;
import org.binar.chapter4.model.response.userResponse;
import org.binar.chapter4.model.users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class invoiceController {
    @Operation(summary = "untuk generate invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = userResponse.class))})
    })
    @PutMapping("/customer/generate-invoice")
    public ResponseEntity generateInvoice(HttpServletResponse response,
                                          @RequestParam("Username") String username,
                                          @RequestParam("NomorKursi") String nomorKursi, @RequestParam("NamaFilm") String namaFilm,
                                          @RequestParam("Tanggal") String Tanggal, @RequestParam("JamMulai") String jamMulai,
                                          @RequestParam("JamSelesai") String jamSelesai) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "delete success!");

        try {
            JasperReport sourceFileName = JasperCompileManager.compileReport
                    (ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "nametag.jrxml").getAbsolutePath());

            // creating our list of beans
            List<Map<String,String>> dataInvoice = new ArrayList<>();
            Map<String, String> bookFilm = new HashMap<>();

            bookFilm.put("Username", username);
            bookFilm.put("NomorKursi", nomorKursi);
            bookFilm.put("NamaFilm", namaFilm);
            bookFilm.put("Tanggal", Tanggal);
            bookFilm.put("JamMulai", jamMulai);
            bookFilm.put("JamSelesai", jamSelesai);
            dataInvoice.add(bookFilm);

            // creating datasource from bean list
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataInvoice);
            Map<String,Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);

            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=nametag.pdf;");

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            return new ResponseEntity(resp, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            resp.put("message", "update gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }


    }
}

