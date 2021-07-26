package com.sone.ccvn.api.services.Util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class ReportsUtil {

    public static final String HEADER_CACHE_CONTROL = "Cache-Control";

    public static final String HEADER_CACHE_CONTROL_VALUE = "no-cache, no-store, must-revalidate";

    public static final String HEADER_PRAGA = "Pragma";

    public static final String HEADER_PRAGA_VALUE = "no-cache";

    public static final String HEADER_EXPIRES = "Expires";

    public static final String HEADER_EXPIRES_VALUE = "0";

    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";


    private ReportsUtil() {
    }

    public static HttpHeaders getHttpHeaders(String nome) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_CACHE_CONTROL, HEADER_CACHE_CONTROL_VALUE);
        headers.add(HEADER_PRAGA, HEADER_PRAGA_VALUE);
        headers.add(HEADER_EXPIRES, HEADER_EXPIRES_VALUE);
        headers.add(HEADER_CONTENT_DISPOSITION, "attachment; filename=" + nome);
        return headers;
    }

    public static HttpHeaders getHttpForJasper(String tipo) {
        return ReportsUtil.getHttpHeaders(tipo + ".pdf");
    }


    public static ResponseEntity<InputStreamResource> output(ByteArrayOutputStream byteArrayOutputStream, String nome) {
        return output(byteArrayOutputStream.toByteArray(), getHttpHeaders(nome));
    }

    public static ResponseEntity<InputStreamResource> output(byte[] byteArrayOutputStream, HttpHeaders headers) {
        return ((ResponseEntity.BodyBuilder) ResponseEntity.ok()
                .headers(headers)).contentLength((long) byteArrayOutputStream.length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new ByteArrayInputStream(byteArrayOutputStream)));
    }


}
