package com.mohap.apiFiles;

public class payloads {

	
	
	public static String processCheckBody() {
		
		return
				
		" {\r\n"
		+ "    \"EntityId\": 9,\r\n"
		+ "    \"UserId\": 153512,\r\n"
		+ "    \"SuggestProcessName\": \"Receiving\",\r\n"
		+ "    \"ControlPoint1\": \"sunil 1\",\r\n"
		+ "    \"ControlPoint2\": \"sample string 5\",\r\n"
		+ "    \"Remarks\": \"this is remarks field only\",\r\n"
		+ "    \"RequestedUserName\": \"PicTest User\",\r\n"
		+ "    \"RequestedUserType\": \"PPIC\",\r\n"
		+ "    \"EntityName\": \"Skye & Walker\",\r\n"
		+ "    \"EntityLic\": \"527784\",\r\n"
		+ "    \"EntityBranch\": \"Food\",\r\n"
		+ "    \"RequestedDateTime\": \"2022-12-09T23:22:54.7698202+05:30\",\r\n"
		+ "    \"RequestedProcessCheckName\": \"Chilled\",\r\n"
		+ "    \"CP1Name\": \"sample string 14\",\r\n"
		+ "    \"CP2Name\": \"sample string 15\",\r\n"
		+ "    \"TotalCount\": 10\r\n"
		+ "  }";		  
		
	}
	
	
	public static String CoursePrice() {
		
		return "{\r\n"
				+ "  \"dashboard\":{\r\n"
				+ "    \"purchaseAmount\": 1162,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "  \"price\": 50,\r\n"
				+ "  \"copies\": 6\r\n"
				+ "},\r\n"
				+ "  {\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "  \"price\": 40,\r\n"
				+ "  \"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "  \"price\": 45,\r\n"
				+ "  \"copies\": 10\r\n"
				+ "},\r\n"
				+ "  {\r\n"
				+ "\"title\": \"Appium\",\r\n"
				+ "  \"price\": 36,\r\n"
				+ "  \"copies\": 7\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}";
				
	} 
	
	public static String AddBook() {
		
		String payload= "{\r\n"
				+ "\"name\": \"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\": \"bczd\",\r\n"
				+ "\"aisle\": \"2270\",\r\n"
				+ "\"author\": \"John foe\"\r\n"
				+ "}\r\n"
				+ "";
				
				return payload;
		
	}
	
	
	
	
}
