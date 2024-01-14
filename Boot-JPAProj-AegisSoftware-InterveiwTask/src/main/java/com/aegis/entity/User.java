package com.aegis.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "USER_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {
	@Id
	@NonNull
	private Integer userId;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private LocalDate dob;
	@NonNull
	private String emailId;
	@NonNull
	private String mobileNo;
	@NonNull
	private Double balance;
	@NonNull
	private String password;
	@NonNull
	private String addrs;

	private UserRole userRole;

}
