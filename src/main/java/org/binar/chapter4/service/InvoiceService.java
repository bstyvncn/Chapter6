package org.binar.chapter4.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.chapter4.model.bookFilm;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoice")
@Service
public class InvoiceService {
    @GetMapping("/generateinvoice")
    public void generateInvoice(HttpServletResponse response, String username, String nomorKursi, String namaFilm,
                                String Tanggal, String jamMulai, String jamSelesai) {
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

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
