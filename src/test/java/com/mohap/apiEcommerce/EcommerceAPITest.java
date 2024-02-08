package com.mohap.apiEcommerce;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.mohap.apiTestingPojo.LoginRequest;
import com.mohap.apiTestingPojo.LoginResponse;
import com.mohap.apiTestingPojo.OrderDetail;
import com.mohap.apiTestingPojo.Orders;

public class EcommerceAPITest {

	public static void main(String[] args) {
	
	
	RequestSpecification reqSpecLogin=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).build();
			
	LoginRequest bodReq=new LoginRequest();
	bodReq.setUserEmail("puniasunil09@gmail.com");
	bodReq.setUserPassword("Api@12345");
	        
	         
	RequestSpecification reqLogin = given().spec(reqSpecLogin).body(bodReq);

			LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
			
			String token = loginResponse.getToken();
			String userId = loginResponse.getUserId();
			
	
			//Add Product   
			
			RequestSpecification reqSpecAddProduct=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addHeader("Authorization", token).build();
			 
	RequestSpecification reqAddProduct=given().spec(reqSpecAddProduct).param("productName", "Poonia").param("productAddedBy", userId)
			.param("productCategory", "fashion").param("productSubCategory", "shirts").param("productPrice", "10555").
			param("productDescription", "product des test1").param("productFor", "women").
			multiPart("productImage",new File("C://Users//punia//Downloads//image for test.jpg"));
			 
			String responseAddProduct=reqAddProduct.when().post("/api/ecom/product/add-product").then().extract().response().asString();
			       
			JsonPath js = new JsonPath(responseAddProduct);

			String productID = js.get("productId");
			System.out.println(productID);
			
			   
			  
			//Create Order
			
     RequestSpecification CreateOrderBaseReq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token)
                  .setContentType(ContentType.JSON).build();
			
     OrderDetail orderdetail=new OrderDetail();
     orderdetail.setCountry("India");
     orderdetail.setProductOrderId(productID);
     
     List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
     orderDetailList.add(orderdetail);
      
     Orders odrs=new Orders();
     odrs.setOrders(orderDetailList);
    
          
		RequestSpecification createOrderReq=	given().log().all().spec(CreateOrderBaseReq).body(odrs);			
		       String responseAddOrder=   createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
					
		       System.out.println("This is response--"+responseAddOrder);
		     //  JsonPath js2=new JsonPath(responseAddOrder);			
				//String orderIDGenerated= js2.get("orders");
			
			 
	//Delete product or item
		       
	RequestSpecification deleteOrderBaseReq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token)
		             .setContentType(ContentType.JSON).build();       
			
			
	RequestSpecification deleteSpec=  given().spec(deleteOrderBaseReq).pathParam("productId", productID);
			  
	String deleteResponse=	deleteSpec. when().delete("/api/ecom/product/delete-product/{productId}").then().extract().response().asString();
			
			  
			JsonPath js1=new JsonPath(deleteResponse);			
			String deletedMessage= js1.get("message");
			System.out.println(deletedMessage);
			
			Assert.assertEquals("Product Deleted Successfully", deletedMessage, "Test Case Pass all steps");
			  
			
	//Delete Order ---not working need to check rest is working fine
			/*
			RequestSpecification deleteOrder=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token)
		             .setContentType(ContentType.JSON).build();       
			
			RequestSpecification    deleteOrderReques=    given().spec(deleteOrder).pathParam("orderID", orderIDGenerated);
			
				String deleteOrderResponse=	deleteOrderReques.when().delete("/api/ecom/order/delete-order/{orderID}").then().extract().response().asString();
			
				JsonPath js3=new JsonPath(deleteOrderResponse);			
				String OrderdeleteMessage= js3.get("message");
				System.out.println(OrderdeleteMessage);
			
			*/
			  
		 
		
	}

}
