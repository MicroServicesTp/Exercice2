package com.dcc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RequestAccountDto {
    private String nom;
    private String tel;
    private Double solde;

}
