package com.spring.ex01;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class LoggingAdvice implements MethodInterceptor {
	// implements MethodInterceptor 꼭!

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전: LoggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed();
		// 메서드를 호출하는 기능
		
		System.out.println("[메서드 호출 후: loggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		
		return object;
	}

}
