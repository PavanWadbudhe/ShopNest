package com.aegis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegis.repository.IUserRepository;
import com.aegis.document.Product;
import com.aegis.document.User;
import com.aegis.document.UserPurchase;
import com.aegis.document.UserRole;
import com.aegis.repository.IProductRepository;
import com.aegis.repository.IUserPurchaseRepository;
import com.aegis.repository.IUserRoleRepository;

@Service("userService")
public class UserMgmtServiceImpl implements IProductMgmtService {
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IProductRepository prodRepo;
	@Autowired
	private IUserPurchaseRepository purchaseRepo;
	@Autowired
	private IUserRoleRepository roleRepo;
	
	int userId;
	int uid;
	double balance;
	int stock;
	String roleName;
	User user;
	UserRole role;
	Product prod;
	
	@Override
	public String saveUserRoleInfo(UserRole role) {
	    role=roleRepo.save(role);
	     roleName=role.getRoleName();
	    int roleId=role.getRoleId();
	    		
		return "User Role are saved with RoleId ::"+roleId;
	}

	@Override
	public String registerUser(User user) {
		user.setUserRole(role);
		   userId=userRepo.save(user).getUserId();
		return userId+" User registered successfully...";
	}
	
	@Override
	public Integer findUserByMail(String email, String password) {
		 user=userRepo.findByEmailId(email);
		
		if(user==null) {
			return -1;
		}
		uid=user.getUserId();
		balance=user.getBalance();
		String pword=user.getPassword();
		int compare=pword.compareTo(password);
		if(compare==0) {
			return 0;
		}else {
			return -2;
		}
	}
	
	@Override
	public String saveProductInfo(Product prod) {
		prod.setCreatedByUser(user);
		 prod=prodRepo.save(prod);
		int prodId= prod.getProductId();
		return "Product saved successfully with id value ::"+prodId;
	}
	
	@Override
	public Product getProductById(Integer id) {
		Optional<Product> opt=prodRepo.findById(id);
		
		return opt.isPresent()?opt.get():opt.orElseThrow(()->new NullPointerException("Product not available..."));
	}
	
	@Override
	public String updateProductInfo(Product prod) {
		int prodId=prodRepo.save(prod).getProductId();
		return prodId+" Id product is updated...";
	}
	
	@Override
	public List<Product> showAllProduct() {
		 
		return prodRepo.findAll();
	}
	
	@Override
	public String removeProductById(Integer prodId) {
		Optional<Product> opt=prodRepo.findById(prodId);
		  if(opt.isPresent()) {
			  Product prod=opt.get();
			  prodRepo.delete(prod);
			  return prod.getProductId()+" Product is Deleted...";
		  }
		 return "Product not available...";
	}
	
	@Override
	public void  buyProductById(Integer prodId, Integer item) {
		if("seller".equalsIgnoreCase(roleName)) {
			System.out.println("Seller should not buy any products...");
		}else {
			Optional<Product> opt=prodRepo.findById(prodId);
			if(opt.isPresent()) {
				Product prod=opt.get();
				double sellPrice=prod.getProductSellPrice();
				 stock=prod.getStockUnit();	
				int userid=prod.getCreatedByUser().getUserId();
				Optional<User> opt2=userRepo.findById(userid);
				
				if(balance >= sellPrice*item) {
					if(stock>=item) {
						user.setBalance(user.getBalance()-(sellPrice*item));
						userRepo.save(user);
						if(opt2.isPresent()) {
							User prodUser=opt2.get();
							prodUser.setBalance(prodUser.getBalance()+sellPrice*item);
							userRepo.save(prodUser);
						}
						prod.setStockUnit(stock-item);
						prodRepo.save(prod);
						System.out.println("Product buyed successfully with Amount ::"+sellPrice*item);
						System.out.println("Remaining Amount ::"+user.getBalance());
						
					}else {
						System.out.println("Stock of the Item not sufficient...");
					}			
				}else {
					System.out.println( "Insufficient balance...");
				}
			}else {
				System.out.println( "Product not available...");
			}
		}
	}

	@Override
	public void userPurchaseProduct(UserPurchase purchase) {
		purchase.setTotalUnit(stock);
		purchase.setProductId(prod);
		purchase.setPurchaseByUser(user);
		purchase.setPurchaseFromUser(user);
		purchaseRepo.save(purchase);
		
	}
	
	

}
