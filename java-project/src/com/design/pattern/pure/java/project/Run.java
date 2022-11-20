package com.design.pattern.pure.java.project;

import com.design.pattern.pure.java.project.facade.Facade;
import com.design.pattern.pure.java.project.singleton.EagerSingleton;
import com.design.pattern.pure.java.project.singleton.LazyHolderSingleton;
import com.design.pattern.pure.java.project.singleton.LazySingleton;
import com.design.pattern.pure.java.project.strategy.AggressiveBehavior;
import com.design.pattern.pure.java.project.strategy.Behavior;
import com.design.pattern.pure.java.project.strategy.DefensiveBehavior;
import com.design.pattern.pure.java.project.strategy.NormalBehavior;
import com.design.pattern.pure.java.project.strategy.Robot;

public class Run {

	public static void main(String[] args) {
		System.out.println("Singleton:");
		LazySingleton lazy = LazySingleton.getInstance();
		System.out.println(lazy);
		lazy = LazySingleton.getInstance();
		System.out.println(lazy);

		EagerSingleton eager = EagerSingleton.getInstance();
		System.out.println(eager);
		eager = EagerSingleton.getInstance();
		System.out.println(eager);

		LazyHolderSingleton lazyHolder = LazyHolderSingleton.getInstance();
		System.out.println(lazyHolder);
		lazyHolder = LazyHolderSingleton.getInstance();
		System.out.println(lazyHolder);

		System.out.println();

		System.out.println("Strategy:");
		Behavior defensively = new DefensiveBehavior();
		Behavior normal = new NormalBehavior();
		Behavior aggresively = new AggressiveBehavior();

		Robot robot = new Robot();
		robot.setBehavior(normal);
		robot.move();
		robot.move();
		robot.setBehavior(defensively);
		robot.move();
		robot.setBehavior(aggresively);
		robot.move();
		robot.move();
		robot.move();

		System.out.println();

		System.out.println("Facade:");
		Facade facade = new Facade();
		facade.migrateCustomer("Vermont", "20390293-232");
	}

}
