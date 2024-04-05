package com.prosigmaka.SpringSecurity.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalHttpResponse<T> {
    private int status;
    private String msg;
    private T data;
}
