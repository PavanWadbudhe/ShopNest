package com.aegis.runners;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Component;

import com.aegis.controller.ProductOperationController;
import com.aegis.document.Product;
import com.aegis.document.User;
import com.aegis.document.UserPurchase;
import com.aegis.document.UserRole;

@Component
public class AegisTaskTestRunner  implements CommandLineRunner{
	@Autowired
	private ProductOperationController controller;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		try(sc){
			try {
				System.out.println("++++++++++++++++ User Role++++++++++++++++");
				System.out.println("Enter RoleName ::");
				String roleName=sc.nextLine();
				System.out.println("Enter Role Descriptoon ::");
				String roleDesc=sc.nextLine();
				
				UserRole urole=new UserRole(new Random().nextInt(100000), roleName, roleDesc);
				//call the method
	             String msg=controller.processUserRole(urole);
	             System.out.println(msg);
	             
	             //infinite loop
	             while(true) {
	            		System.out.println("******Choice*********");
	            		System.out.println("\t1.RegisterUser\n\t2.Login\n\t3.exit");
	            		System.out.println("Enter the choice");
	            		
	            		//write switch case
	            		switch(Integer.parseInt(sc.nextLine())) {
	            		
	            		case 1: 
	            			System.out.println("==========Enter the details=========");
	            			System.out.println("Enter the FirstName ::");
	            			String fName=sc.nextLine();
	            			int len=fName.length();
	            			
	            			//check name is valid or not 
	            			boolean a=false;
	            			
	            			for(int i=0;i<len;i++) {
	            				char ch=fName.charAt(i);
	            				int k=(int)ch;
	            				if(k>=65 && k<=90 || k>=97 &&k<=122)   {
	            					a=true;
	            				}
	            			}
	            			if(a) {
	            				System.out.println("Enter the LastName ::");
	            				String lName=sc.nextLine();
	            				
	            				//check name is valid or not 
	            				boolean b=false;
	            				
	            				for(int i=0;i<lName.length();i++) {
	            					char ch=lName.charAt(i);
	            					int k=(int)ch;
	            					if(k>=65 && k<=90 || k>=97 &&k<=122)   {
	            						b=true;
	            					}
	            				}
	            				if(b) {
	            					System.out.println("Enter DateOfBirth (yyyy-MM-dd)::");
	            					String dobString=sc.nextLine();
	            					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            					LocalDate dob=LocalDate.parse(dobString, formatter);
	            					
	            					System.out.println("Enter Email ::");
	            					String mail=sc.nextLine();
	            					
	            					//check mail validation 
	            					boolean c=false;
	            					
	            					for(int i=0;i<mail.length();i++) {
	            						char ch=mail.charAt(i);
	            						if(ch=='@' ) {
	            								c=true;									
	            						}
	            					}
	            					if(c) {
	            						System.out.println("Enter Mobile::");
	            						String moNo=sc.nextLine();
	            						System.out.println("Enter Balance ::");
	            						Double bal=Double.parseDouble(sc.nextLine());
	            						System.out.println("Enter the password::");
	            						String password=sc.nextLine();
	            						System.out.println("Enter the Address ::");
	            						String addrs=sc.nextLine();
	            						
	            						//create obj
	            						User user=new User(new Random().nextInt(100000),fName, lName, dob, mail, moNo, bal, password,addrs);
	            						//invoke method
	            						String userMsg=controller.processAddUserDetails(user);
	            						
	            						System.out.println(userMsg);
	            					}else {
	            						System.out.println("Invalid Email...");
	            					}
	            				}else {
	            					System.out.println("Envalid Lastname...");
	            				}
	            			}else {
	            				System.out.println("Invalid FirstName...");
	            			}
	            			break;
	            			
	            		case 2:
	            			System.out.println("Enter Email ::");
	            			String email=sc.nextLine();
	            			System.out.println("Enter password ::");
	            			String password=sc.nextLine();
	            			//invoke method
	            			int val=controller.processLogin(email, password);
	            			
	            			if(val== -1) {
	            				System.out.println("Envalid email...");
	            			}else if(val== -2) {
	            				System.out.println("Envalid password...");
	            			}else {
	            				System.out.println("Login is successful...");
	            				
	            				xyz:
	            				while(true) {
	            					System.out.println("********Choice**********");
	            					System.out.println("\t1.Seller\n\t2.Buyer\n\t3.exit");
	            					switch(Integer.parseInt(sc.nextLine())) {
	            					case 1:
	            						pqr:
	            						while(true) {
	            							System.out.println("========WELLCOME SELLER==========");
	            							System.out.println("*****Choice******");
	            							System.out.println("\t1.Crete Product\n\t2.Update Product\n\t3.Delete product");
	            							
	            							switch(Integer.parseInt(sc.nextLine())) {
	            							case 1:
	            								System.out.println("Enter Product Name ::");
	            								String pname=sc.nextLine();
	            								boolean c=false;
	            								
	            								for(int i=0; i<pname.length(); i++) {
	            									char ch=pname.charAt(i);
	            									int k=(int)ch;
	            									if(k>=65 && k<=90 || k>=97 &&k<=122)   {
	            										c=true;
	            									}
	            								}
	            								
	            								if(c) {
	            									System.out.println("Enter Product Description ::");
	            									String desc=sc.nextLine();
	            									System.out.println("Enter Product Image (path) ::");
	            									String path=sc.nextLine();
	            									System.out.println("Enter product Sell price::");
	            									Double sellPrice=Double.parseDouble(sc.nextLine());
	            									System.out.println("Enter product Cost price::");
	            									Double costPrice=Double.parseDouble(sc.nextLine());
	            									System.out.println("Enter the stock of product ::");
	            									int stockUnit=Integer.parseInt(sc.nextLine());
	            									System.out.println("product is Deleted (yes/no)::");
	            									boolean isDeleted=Boolean.parseBoolean(sc.nextLine());
	            									
	            									Product prod=new Product();
	            									prod.setProductId(new Random().nextInt(200000));
	            									prod.setProductName(pname);
	            									prod.setProductDesc(desc);
	            									prod.setProductImg(path);
	            									prod.setProductSellPrice(sellPrice);
	            									prod.setProductCostPrice(costPrice);
	            									prod.setStockUnit(stockUnit);
	            									prod.setCreateDate(LocalDate.now());
	            									prod.setIsDeleted(isDeleted);
	            									
	            									String prodMsg=controller.processProductInfo(prod);
	            									System.out.println(prodMsg);
	            									
	            								}else {
	            									System.out.println("Enter correct product name...");
	            									continue;
	            								}
	            								break pqr;
	            							case 2:
	            								List<Product> list=controller.processShowingAllProduct();
	            								System.out.println("=============Available Products===============");
	            								list.forEach(prod->{
	            									System.out.println("ProductId ::"+prod.getProductId()+"   "+"ProductName ::"+prod.getProductName()+"   "+
	            								                                         "ProductDesc ::"+prod.getProductDesc()+"   "+"ProductImgPath ::"+prod.getProductImg()+"   "+
	            											                              "ProductSellPrice ::"+prod.getProductSellPrice()+"   "+"ProductCostPrice ::"+prod.getProductCostPrice()+"    "+
	            								                                          "ProductStock ::"+prod.getStockUnit()+"   "+"CreateDate ::"+prod.getCreateDate()+"   "+
	            											                              "ProductIsDeleted ::"+prod.getIsDeleted()+"   "+"ProductCreatedByUser ::"+prod.getCreatedByUser());
	            									
	            								});
	            								System.out.println("Enter ProductID :: ");
	            								int prodId=Integer.parseInt(sc.nextLine());
	            								Product prod=controller.processProductById(prodId);
	            								
	            								System.out.println("Enter product description ::");
	            								String desc=sc.nextLine();
	            								System.out.println("Enter Image (path)");
	            								String imgPath=sc.nextLine();
	            								System.out.println("Enter Sell price ::");
	            								Double sellPrice=Double.parseDouble(sc.nextLine());
	            								System.out.println("Enter Cost Price ::");
	            								Double costPrice=Double.parseDouble(sc.nextLine());
	            								System.out.println("Enter StockUnit ::");
	            								int stock=Integer.parseInt(sc.nextLine());
	            								
	            								prod.setProductDesc(desc);
	            								prod.setProductImg(imgPath);
	            								prod.setProductSellPrice(sellPrice);
	            								prod.setProductCostPrice(costPrice);
	            								prod.setStockUnit(stock);
	            								
	            								String updateMsg=controller.processUpdationProduct(prod);
	            								System.out.println(updateMsg);
	            								break pqr;
	            							case 3:
	            								List<Product> list2=controller.processShowingAllProduct();
	            								System.out.println("=============Available Products===============");
	            								list2.forEach(prod2->{
	            									System.out.println("ProductId ::"+prod2.getProductId()+"   "+"ProductName ::"+prod2.getProductName()+"   "+
	            								                                         "ProductDesc ::"+prod2.getProductDesc()+"   "+"ProductImgPath ::"+prod2.getProductImg()+"   "+
	            											                              "ProductSellPrice ::"+prod2.getProductSellPrice()+"   "+"ProductCostPrice ::"+prod2.getProductCostPrice()+"    "+
	            								                                          "ProductStock ::"+prod2.getStockUnit()+"   "+"CreateDate ::"+prod2.getCreateDate()+"   "+
	            											                              "ProductIsDeleted ::"+prod2.getIsDeleted()+"   "+"ProductCreatedByUser ::"+prod2.getCreatedByUser());
	            									
	            								});
	            								System.out.println("Enter the ProductId ::");
	            								int productId=Integer.parseInt(sc.nextLine().replace(" ", ""));
	            								
	            								String deleteMsg=controller.processDeletingProduct(productId);
	            								System.out.println(deleteMsg);
	            								break pqr;
	            								
	            								default :
	            									System.out.println("enter correct choice...");
	            							}
	            						}
	            						
	            						break;
	            					case 2:
	            						System.out.println("========WELLCOME BUYER==========");
	            						List<Product> list=controller.processShowingAllProduct();
	            						System.out.println("=============Available Products===============");
	            						list.forEach(prod->{
	            							System.out.println("ProductId ::"+prod.getProductId()+"   "+"ProductName ::"+prod.getProductName()+"   "+
	            						                                         "ProductDesc ::"+prod.getProductDesc()+"   "+"ProductImgPath ::"+prod.getProductImg()+"   "+
	            									                              "ProductSellPrice ::"+prod.getProductSellPrice()+"   "+"ProductCostPrice ::"+prod.getProductCostPrice()+"    "+
	            						                                          "ProductStock ::"+prod.getStockUnit()+"   "+"CreateDate ::"+prod.getCreateDate()+"   "+
	            									                              "ProductIsDeleted ::"+prod.getIsDeleted()+"   "+"ProductCreatedByUser ::"+prod.getCreatedByUser());
	            							
	            						});
	            						abc:
	            						while(true) {
	            							System.out.println("******Choice********");
	            							System.out.println("\t1.Buy\n\t2.exit");
	            							System.out.println("Enter the choice ::");
	            							switch(Integer.parseInt(sc.nextLine())) {
	            							case 1:
	            								System.out.println("Enter the ProductId ::");
	            								int productId=Integer.parseInt(sc.nextLine().replace(" ", ""));
	            								System.out.println("How many items to buy ::");
	            								int items=Integer.parseInt(sc.nextLine());
	            								
	            								controller.processToBuyProduct(productId, items);
	            								UserPurchase purchase=new UserPurchase(new Random().nextInt(1000000), LocalDate.now());
	            								controller.processUserPurchase(purchase);
	            								break abc;
	            								
	            							case 2:
	            								System.out.println("Exited successfully...");
	            								break abc;
	            								
	            							default:
	            									System.out.println("Enter correct choice...");
	            							}
	            						}
	            						
	            						break;
	            					case 3:
	            						System.out.println("Exited successfully...");
	            						break xyz;
	            						default:
	            							System.out.println("Invalid Choice...");									
	            			     	}            						
	            				}
	            			}
	            			
	            			break;
	            			
	            		case 3:
	            			 System.out.println("You are Exited Successfully...");
	            			 System.exit(0);
	            			break;
	            			
	            		default:
	            			System.out.println("Invalid choice...");
	            		}
	            	}
	             
			}catch(NullPointerException ne) {
				System.out.println("Enter valid Id ::"+ne.getMessage());
			}
			catch(IncorrectResultSizeDataAccessException ersdae) {
				System.out.println("duplicate email..."+ersdae.getMessage());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}

}
