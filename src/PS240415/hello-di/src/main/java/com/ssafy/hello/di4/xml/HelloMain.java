package com.ssafy.hello.di4.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class HelloMain {
	
		public static void main(String[] args) {
			System.out.println("프로그램 시작!!");
			
//			TODO :com/ssafy/hello/di4/xml/applicationContext.xml를 사용하여 ApplicationContext 생성
			
			//이 설정을 읽어들여서 context라는 객체를 만들어 줘
			ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/xml/applicationContext.xml");
			
			//스프링 컨테이너(xml)에 관리해야 하는 bean이 2개 있다고 알려줌 ! -> 따라서 내부적으로 이 객체들을 생성하기 위해 생성자 호출
			//객체 생성을 내부적으로 끝냄.
			
			System.out.println("xml 다 읽음!! 시작!!");
			
			//id가 kor로 생긴 요소를 HelloMessageKor.class로 형변환해서 줌
			HelloMessage helloMessage = context.getBean("kor", HelloMessageKor.class);
			String greeting = helloMessage.hello("안효인");
//			String greeting = helloMessage.hello("Mr. An");
			
			System.out.println(greeting);
			
			System.out.println("----------------------------------------");
			
			HelloMessage kor1 = context.getBean("kor", HelloMessage.class);
			HelloMessage kor2 = context.getBean("kor", HelloMessage.class);
			System.out.println(kor1 + " ::::: " + kor2);
			//생성되는거 보면 알아서 싱글톤이 되고 있음!!!
		}
		
	}
