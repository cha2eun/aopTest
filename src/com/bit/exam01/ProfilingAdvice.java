package com.bit.exam01;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {
	public void afterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"��   ������������ ����");
	}
	
	public void afterreturning(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"��   �� �� �Ϸ� ��");
	}
	
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"�� �Ϸ� ��");
	}
	
//	public void before() {		�޼ҵ� �̸� �Ⱦ˷��ִ� ����
//		System.out.println("ŸŶ�� �Ǵ� �޼ҵ� ���� ��");
//	}
	
	public void before(JoinPoint joinpoint) {
		String methodName= joinpoint.getSignature().toLongString();
		System.out.println(methodName+"�޼ҵ� ���� ��");
	}
	
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object re = null;
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"����");
		long start = System.currentTimeMillis();
		try {
			re=joinPoint.proceed();//Ÿ���� �Ǵ� �޼ҵ带 ȣ�� 
			
		} catch (Throwable e) {	//exception�� error�� ������ throwable��
			e.printStackTrace();
		}	
		System.out.println(methodName+"����");
		long finish = System.currentTimeMillis();
		System.out.println("�ɸ��ð�:"+(finish-start));

		return re;
	}

}
