package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller - 문자열 반환 시, @ResponseBody를 꼭 써야 한다.
public class HelloController {
	
	public HelloController() {
		System.out.println("HelloController 기본 생성자");
	}
	
	@GetMapping(value="/hello")
	//@ResponseBody - RestController로 잡을 경우, 문자열 반환 시 @ResponseBody를 쓰지 않아도 된다.
	public String hello(String name) {
		return "안녕하세요 " + name + "님";
	}
}

//@RestController를 사용할 경우, 문자열 반환 시 @ResponseBody를 써줄 필요 없지만 @Controller를 사용할 경우, 문자열 반환 시 ReponseBody를 꼭 써줘야 한다.