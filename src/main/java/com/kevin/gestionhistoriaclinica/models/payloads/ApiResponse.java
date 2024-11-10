package com.kevin.gestionhistoriaclinica.models.payloads;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private Date time = new Date();
    private String message;
    private String url;
    private Map<String, String> errors;

    public ApiResponse(String mensaje, String url) {
        this.message = mensaje;
        this.url = url.replace("uri=", "");
    }

    public ApiResponse(String message, String url, Map<String, String> errors) {
        this.message = message;
        this.url = url;
        this.errors = errors;
    }
}
