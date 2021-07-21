package com.sone.ccvn.api.services;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportService {

   String exportReport(String reportFormat) throws FileNotFoundException, JRException;
}
