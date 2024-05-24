package com.ssafy.hello.di5.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

	@Component(value = "kor") //value= 생략 가능
	//@Controller(컨트롤러), @Service(서비스), @Repository(dao) -> Component의 자식이므로 대체 가능.
	@Scope(value = "singleton")
	public class HelloMessageKor implements HelloMessage {
		
		public HelloMessageKor() {
			System.out.println("HelloMessageKor Contructor Call!!!!!!!!!");
		}
	
		public String hello(String name) {
			return "안녕하세요 " + name;
		}
		
	}
