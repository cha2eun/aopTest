package com.bit.exam01;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {
	public void afterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"가   비정상적으로 종료");
	}
	
	public void afterreturning(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"가   정 상 완료 후");
	}
	
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"가 완료 후");
	}
	
//	public void before() {		메소드 이름 안알려주는 버전
//		System.out.println("타킷이 되는 메소드 실행 전");
//	}
	
	public void before(JoinPoint joinpoint) {
		String methodName= joinpoint.getSignature().toLongString();
		System.out.println(methodName+"메소드 실행 전");
	}
	
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object re = null;
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"시작");
		long start = System.currentTimeMillis();
		try {
			re=joinPoint.proceed();//타켓이 되는 메소드를 호출 
			
		} catch (Throwable e) {	//exception과 error의 상위가 throwable임
			e.printStackTrace();
		}	
		System.out.println(methodName+"종료");
		long finish = System.currentTimeMillis();
		System.out.println("걸린시간:"+(finish-start));

		return re;
	}

}
