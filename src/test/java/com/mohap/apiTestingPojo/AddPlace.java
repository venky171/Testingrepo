package com.mohap.apiTestingPojo;

import java.util.List;

public class AddPlace {

	
	private String name;
	private long phone_number;
	private String address;
	private List<String> types;
	private String website;
	private String language;
	private Location location;
	  
	 
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	private int accuracy;
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	
	/*
	 *    Json example which JSON we have serialized
{
"location":{
"lat":-38.383494,
"lng":33.427362
},

"accuracy":50,
"name":"Frontline house",
"phone_number":"+91801234342",
"address":" this addess is only for testing",
"types":[
"shoe park",
"shop"
],

"website":"http://google.com",
"language":"French-IN",
} 
	 * 
	 */
	
	
}
