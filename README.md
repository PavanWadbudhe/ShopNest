I got a Task from a software company and I asked to complete these Task.
I completed these task as a standalone application in Spring Boot framework i.e. Spring Boot Data JPA, Hibernate and MongoDB and I use Eclipse IDE as Build tool . 
Project description is 
Thera are 4 table i.e.User_Role table, User table, Product table and User_Purchase table.
User Roles: [Buyer, Seller] 
What needs to be implemented? 
1) Create a registration form with following fields, and use proper validations only on 
client side. 
2) fields: [firstname, lastname, email, dob, mobile, userType, balance] 
3) Create a login page, use fields [email, password], and use proper validations. 
4) Only Seller can create, update, delete their product, so create a page for seller to add, 
update, delete product. A Seller should not be able to buy any product. Remember all 
operation must be done on single page. use following fields 
5) Add Product Form fields: [productName, description, image, sellPrice, costPrice, 
StockUnit] 
6) Once product is added by seller, will be displayed to buyers. 
7) Update Product Form fields: [description, image, sellPrice, costPrice, StockUnit] while 
updating a product, productname must not be editable. 
8) Display list of product on the same page with all column details and a delete button, on 
delete that product must be soft delete from Database. 
9) Create a page that will display all the products and its information available in the 
system, using this page Buyer will allow to buy particular product with a field "Total 
Units" to allow Buyer to specify how many items buyer want to buy and a Buy button. 
- When user click on buy button user proper validation on client side. 
- When Buyer buy something, following things must be done. 
- Buyer balance = Buyer balance - (Total Units * product sell price) 
- Seller balance = Seller Balance + (Total Units * product Sell price) 
- Product Stock Unit = Stock Unit - Total Units 
- When stock unit become 0, do not display on page. 
10) Create a page to display and list out all the purchase information for buyer. 
11) Create a page to display and list out all the selling information for the sellers. 
