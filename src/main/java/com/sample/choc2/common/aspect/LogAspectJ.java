package com.sample.choc2.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

class LogAspectJ {

	public LogAspectJ() {
		System.out.println("\nCommon ::" + this.getClass() + "\n");
		// TODO Auto-generated constructor stub
	}

	public Object invoke(ProceedingJoinPoint joinpoint) throws Throwable {
		
		
		System.out.println("AOP inovoke method 실행..");

		System.out.println("[before Cross Concern] : " + joinpoint.getTarget().getClass().getName() + "."
				+ joinpoint.getSignature().getName());

		if (joinpoint.getArgs().length != 0) {
			System.out.println("[before Cross Concern] : " + joinpoint.getArgs()[0]);
		}

		Object obj = joinpoint.proceed();

		System.out.println("[after Cross Concern] " + obj);

		return obj;
	}

}