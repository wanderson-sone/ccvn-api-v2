package com.sone.ccvn.api.services.impl;

import com.sone.ccvn.api.services.mapper.ComunidadeMapper;
import com.sone.ccvn.api.services.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.services.dtos.request.ComunidadeReportDTO;
import com.sone.ccvn.api.services.ComunidadeService;
import com.sone.ccvn.api.services.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.*;
import java.util.*;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ComunidadeService service;

    @Autowired
    private ComunidadeMapper comunidadeMapper;

    @Override
    public ResponseEntity<byte[]> exportReport(String reportFormat) throws FileNotFoundException, JRException {

//        String path = "/home/wandeson/Documentos/SAIDA_PDF_TEST";

        List<ComunidadeDTO> all = service.findAll();

        List<ComunidadeReportDTO> comunidadeReportDTOS = comunidadeMapper.toListDto(all);

//        //load file and compile it
//        File file = ResourceUtils.getFile("classpath:reports/text.jrxml");
//
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comunidadeReportDTOS);
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("CommunityCollectionBeanParam", dataSource);
//
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(comunidadeReportDTOS));
//
//        if (reportFormat.equalsIgnoreCase("html")) {
//            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/comunidade.html");
//        }
//
//        if (reportFormat.equalsIgnoreCase("pdf")) {
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/comunidade.pdf");
//        }
//
//        return "report generated in path : " + path;


//--------------------------------------------------------------------------------------------------
        /* Video aula two */

//        /* Output file location to create report in pdf form */
//        String outputFile = "/home/wandeson/Documentos/SAIDA_PDF_TEST/" + "JasperReportExample.pdf";
//
//        File inputFile = ResourceUtils.getFile("classpath:reports/text.jrxml");
//
//        /* Convert List to JRBeanCollectionDataSource */
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comunidadeReportDTOS);
//
//        /* compiling jrxml with help of JasperReport class */
//        InputStream input = new FileInputStream(inputFile);
//        JasperDesign jasperDesign = JRXmlLoader.load(input);
//        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//
//        /* Map to hold Jasper report Parameters */
////        Map<String, Object> parameters = new HashMap<>();
////        parameters.put("CommunityCollectionBeanParam", dataSource);
//
//        /* read jrxml file and creating jasper design object */
//
//
//        /* Using JasperReport object to generate PDF */
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
//
//        /* call jasper engine to display report in jasperviewer windows */
////        JasperViewer.viewReport(jasperPrint);
//
//        /* outputStream to create PDF */
//        OutputStream outputStream = new FileOutputStream(outputFile);
//
//        /* Write content to PDF file */
//        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//
//        return "File Generated";



//        ---------------------------------------------------------------------------------

        /*
        * Impressão no browser
        *
        */

       File file = ResourceUtils.getFile("classpath:reports/text.jrxml");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comunidadeReportDTOS);

        JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(file));

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("Lista de Comunidades", "title");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=community.pdf" );

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }
}
