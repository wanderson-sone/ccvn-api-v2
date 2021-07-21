package com.sone.ccvn.api.services.impl;

import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.services.ComunidadeService;
import com.sone.ccvn.api.services.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ComunidadeService service;

    @Override
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path = "/home/wandeson/Documentos/SAIDA_PDF_TEST";

        List<ComunidadeDTO> all = service.findAll();

        File file = ResourceUtils.getFile("classpath:/reports/community_list.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(all);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Wanderson-ccvn - SONE");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if(reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/comunidade.html");
        }

        if(reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/comunidade.pdf");
        }

        return "report generated in path : " + path;
    }
}
