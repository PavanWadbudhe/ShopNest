package com.aegis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aegis.document.Product;
import com.aegis.document.User;
import com.aegis.document.UserPurchase;
import com.aegis.document.UserRole;
import com.aegis.service.IProductMgmtService;

@Controller("prodController")
public class ProductOperationController {
	@Autowired
	private IProductMgmtService prodService;
	
	public String processUserRole(UserRole role) {
		return prodService.saveUserRoleInfo(role);
	}
	
	public String processAddUserDetails(User user) {
		return prodService.registerUser(user);
	}
	
	public Integer processLogin(String email,String password) {
		return prodService.findUserByMail(email, password);
	}

	public String processProductInfo(Product prod) {
		return prodService.saveProductInfo(prod);
	}
	
	public Product processProductById(Integer id) {
		return prodService.getProductById(id);
	}
	
	public String processUpdationProduct(Product prod) {
		return prodService.updateProductInfo(prod);
	}
	
	public List<Product> processShowingAllProduct() {
		return prodService.showAllProduct();
	}
	
	public String processDeletingProduct(Integer prodId) {
		return prodService.removeProductById(prodId);
	}
	
	public void processToBuyProduct(Integer prodId, Integer items) {
		prodService.buyProductById(prodId, items);
	}
	
	public void processUserPurchase(UserPurchase purchase) {
		prodService.userPurchaseProduct(purchase);
	}
}
