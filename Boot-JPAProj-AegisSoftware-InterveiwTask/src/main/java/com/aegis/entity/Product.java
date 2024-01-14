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

@Document(collection = "PRODUCT_TAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable {
	@Id
	@NonNull
	private Integer productId;
	@NonNull
	private String productName;
	@NonNull
	private String productDesc;
	@NonNull
	private String productImg;
	@NonNull
	private Double productSellPrice;
	@NonNull
	private Double productCostPrice;
	@NonNull
	private Integer stockUnit;
	@NonNull
	private LocalDate createDate;
	@NonNull
	private Boolean isDeleted;
	
	private User createdByUser;
	
}
