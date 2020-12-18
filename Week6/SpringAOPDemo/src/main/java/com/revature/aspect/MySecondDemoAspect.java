package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


// @Order can take any number from Integer.MIN_VALUE to Integer.MAX_VALUE, therefore you can have negative numbers, positive numbers
// smaller numbers take more precedence over larger numbers. 
// So If you have two aspects, the one with the smaller number will have the advice with matching PointCuts to the target methods would execute
// first
@Order(1)
@Aspect
@Component
public class MySecondDemoAspect {

	@Before("com.revature.aspect.MyDemoAspect.allSettersInDaoPackage() || com.revature.aspect.MyDemoAspect.allGettersInDaoPackage()")
	public void beforeSetterAndGetterMethodsInDaoPackage(JoinPoint jp) {
		String method = jp.getSignature().toLongString();
		
		System.out.println("Executing beforeSetterAndGetterMethodsInDaoPackage advice on method: " + method);
	}
	
}
