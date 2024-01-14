package com.aegis.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "USER_PURCHASE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserPurchase implements Serializable{
	@Id
	@NonNull
	private Integer purchaseId;
	@NonNull
	private LocalDate purchaseDate;
	
	private Product productId;

	private Integer totalUnit;
	
	private User purchaseByUser;
	
	private User purchaseFromUser;

}
