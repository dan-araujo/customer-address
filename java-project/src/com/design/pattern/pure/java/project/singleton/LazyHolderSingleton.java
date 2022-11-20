package com.design.pattern.pure.java.project.singleton;

public class LazyHolderSingleton {

	private static class InstanceHolder {
		public static LazyHolderSingleton instance = new LazyHolderSingleton();
	}

	private LazyHolderSingleton() {
		super();
	}

	public static LazyHolderSingleton getInstance() {
		return InstanceHolder.instance;
	}

}
