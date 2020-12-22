package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.revature.model.Planet;

@Aspect
@Component
@Order(0)
public class MyDemoAspect {

	@Pointcut("execution(* com.revature.dao.*.*(..))")
	public void allMethodsInDaoPackage() {}
	
	@Pointcut("execution(public void com.revature.dao.*.set*(..))")
	public void allSettersInDaoPackage() {}
	
	@Pointcut("execution(public * com.revature.dao.*.get*(..))")
	public void allGettersInDaoPackage() {}
	
	// Here I can add all of my advice
	
	// So here, for example I can specify an @Before advice
	// General pattern: "execution(modifiers-pattern? return-type-pattern declaring-type-pattern? 
	// 								method-name-pattern(param-pattern) throws-pattern?)"
	@Before("allMethodsInDaoPackage()")
	public void beforeMethodsInDaoPackage(JoinPoint jp) {
		
		String method = jp.getSignature().toLongString();
		
		System.out.println("Executing @Before advice on method: " + method);
		
	}
	
	@AfterReturning(pointcut = "execution(public com.revature.model.Planet getPlanetById(int))", 
					returning = "result")
	public void afterReturningGetPlanetById(JoinPoint jp, Planet result) {
		System.out.println("getPlanetById(int) successfully returned " + result);
	}
	
	@AfterThrowing(pointcut = "execution(public com.revature.model.Planet getPlanetById(int))", 
					throwing="theException")
	public void afterThrowingGetPlanetById(JoinPoint jp, Exception theException) {
		System.out.println("getPlanetById(int) threw exception " + theException);
	}
	
	@Around("execution(* com.revature.dao.PlanetDAO.addPlanet(com.revature.model.Planet, ..))")
	public Planet aroundAddPlanet(ProceedingJoinPoint pjp) {
		
		System.out.println("Printing args");
		for (Object object : pjp.getArgs()) {
			System.out.println("====> " + object);
		}
		
		System.out.println("Inside @Around: This is before addPlanet executes");
		long startTime = System.currentTimeMillis();
		
		Planet planet = null;
		try {
			// addPlanet is represented here as pjp.proceed(..)
			// Here I am hijacking what the user passed in
//			planet = (Planet) pjp.proceed(new Object[] { new Planet("Mars", 25.5, -100) });
			planet = (Planet) pjp.proceed(pjp.getArgs());
			planet.setId(10000);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Inside @Around: This is after addPlanet executes");
		System.out.println("Inside @Around: addPlanet took " + (endTime - startTime) / 1000 + " seconds");
		
		return planet;
	}
	
	@Around("@annotation(com.revature.annotations.LoggedInUsersOnly)")
	public Object aroundAdminsOnly(ProceedingJoinPoint pjp) throws Throwable {
		// HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		// HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
		
		// HttpSession session = request.getSession(false);
		
		// if (session == null || session.getAttribute("currentUser") == null) {
		//	response.setStatus(401);
		//	return null;
		// }
		//
		boolean userAuthenticated = false;
		if (!userAuthenticated) {
			// Stop method execution from happening, since now .proceed would be unreachable as the advice ends early
			return null;
		}
		
		
		// Otherwise, they are logged in 
		Object result = pjp.proceed(pjp.getArgs());
		return result;
	}
	
}
