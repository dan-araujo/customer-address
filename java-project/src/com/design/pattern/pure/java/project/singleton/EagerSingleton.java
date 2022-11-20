package com.design.pattern.pure.java.project.singleton;

public class EagerSingleton {

	private static EagerSingleton instance = new EagerSingleton();

	private EagerSingleton() {
		super();
	}

	public static EagerSingleton getInstance() {
		return instance;
	}

}
