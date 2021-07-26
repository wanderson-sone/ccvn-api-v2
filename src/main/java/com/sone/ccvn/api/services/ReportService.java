package com.sone.ccvn.api.services;

import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;

public interface ReportService {

   ResponseEntity<byte[]> exportReport(String reportFormat) throws FileNotFoundException, JRException;

//   Map<String, Object> getParameters();
//
//   ResponseEntity<InputStreamResource> defineReturnOfReport(HttpHeaders headers, Object dataSource, String path) throws JRException;
}
