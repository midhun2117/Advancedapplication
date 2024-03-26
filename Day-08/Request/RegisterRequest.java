package com.example.demo.dto.Request;


import com.example.demo.entity.enumerate.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor  
@NoArgsConstructor
public class RegisterRequest {
    private int userid;
	private String username;
	private String emailid;
	private String mobileno;
	private String password;
	
    private Role roles;
}

