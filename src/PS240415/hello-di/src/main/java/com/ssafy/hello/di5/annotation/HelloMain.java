package com.ssafy.hello.di5.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloMain {

	public static void main(String[] args) {
		//스프링 들어가면 이 메인 내용은 알아서 다 해줌!!!
		
//		TODO :com/ssafy/hello/di5/xml/applicationContext.xml를 사용하여 ApplicationContext 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di5/annotation/applicationContext.xml");
		
		//스프링 컨테이너(xml)에 관리해야 하는 bean이 2개 있다고 알려줌 ! -> 따라서 내부적으로 이 객체들을 생성하기 위해 생성자 호출
		//객체 생성을 내부적으로 끝냄.
		
		System.out.println("xml 다 읽음!! 시작!!");
		
		HelloMessage helloMessage = context.getBean("kor", HelloMessage.class);
		
		String greeting = helloMessage.hello("안효인");
//		String greeting = helloMessage.hello("Mr. An");
		
		System.out.println(greeting);
		
		System.out.println("----------------------------------------");
		
//		HelloMessage kor1 = context.getBean("kor", HelloMessageKor.class);
//		HelloMessage kor2 = context.getBean("kor", HelloMessageKor.class);
//		System.out.println(kor1 + " ::::: " + kor2);
		
	}
	
}
