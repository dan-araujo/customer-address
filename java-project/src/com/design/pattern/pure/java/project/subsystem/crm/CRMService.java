package com.design.pattern.pure.java.project.subsystem.crm;

public class CRMService {

	private CRMService() {
		super();
	}

	public static void recordCustomer(String name, String cep, String city, String state) {
		System.out.println("Customer saved in Customer Relationship Management System");
		System.out.println(name);
		System.out.println(cep);
		System.out.println(city);
		System.out.println(state);
	}

}
