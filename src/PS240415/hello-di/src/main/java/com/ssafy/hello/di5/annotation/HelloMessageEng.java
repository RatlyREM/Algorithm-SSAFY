package com.ssafy.hello.di5.annotation;

import org.springframework.stereotype.Component;

//이 annotation을 달게 되면 이건 spring이 관리하는 bean이 됨.

@Component
public class HelloMessageEng implements HelloMessage {

	public HelloMessageEng() {
		System.out.println("HelloMessageEng Contructor Call!!!!!!!!!");
	}
	
	public String hello(String name) {
		return "Hello " + name;
	}
	
}
