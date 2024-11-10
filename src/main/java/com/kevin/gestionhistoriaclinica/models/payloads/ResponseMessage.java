package com.kevin.gestionhistoriaclinica.models.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
    @Builder.Default
    private boolean success = true;
    @Builder.Default
    private String message = "";
    private Object data;
}
