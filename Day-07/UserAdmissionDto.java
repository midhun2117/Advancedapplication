package com.example.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class UserAdmissionDto {
          private int id;
            private String username;
            private String Coursename;
            private int quantity;
            private float totalbill;
    }
    
