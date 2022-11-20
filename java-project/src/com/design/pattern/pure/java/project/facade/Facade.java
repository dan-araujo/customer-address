package com.design.pattern.pure.java.project.facade;

import com.design.pattern.pure.java.project.subsystem.cep.CepAPI;
import com.design.pattern.pure.java.project.subsystem.crm.CRMService;

public class Facade {

	public void migrateCustomer(String name, String cep) {
		String city = CepAPI.getInstance().recoverCity(cep);
		String state = CepAPI.getInstance().recoverState(cep);

		CRMService.recordCustomer(name, cep, city, state);
	}

}
