package com.aegis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document(collection = "USER_ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {
	@Id
	@NonNull
	private Integer roleId;
	@NonNull
	private String roleName;
	@NonNull
	private String roleDesc;
	
}
