package com.prosigmaka.SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Timestamp userDate;
}
