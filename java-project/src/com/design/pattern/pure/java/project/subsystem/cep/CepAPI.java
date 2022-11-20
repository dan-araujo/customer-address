package com.design.pattern.pure.java.project.subsystem.cep;

public class CepAPI {
	private static CepAPI instance = new CepAPI();

	private CepAPI() {
		super();
	}

	public static CepAPI getInstance() {
		return instance;
	}

	public String recoverCity(String cep) {
		return "Recife";
	}

	public String recoverState(String cep) {
		return "PE";
	}

}
