package com.aegis.service;

import java.util.List;

import com.aegis.entity.Product;
import com.aegis.entity.User;
import com.aegis.entity.UserPurchase;
import com.aegis.entity.UserRole;

public interface IProductMgmtService {
	public String saveUserRoleInfo(UserRole role);
	public String registerUser(User user);
	public Integer findUserByMail(String mail, String password);
	public String saveProductInfo(Product prod);
	public Product getProductById(Integer id);
	public String updateProductInfo(Product prod);
	public List<Product> showAllProduct();
	public String removeProductById(Integer prodId);
	public void buyProductById(Integer prodId, Integer item);
	public void userPurchaseProduct (UserPurchase purchase);

}
