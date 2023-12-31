package ma.cigma.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	@Value("${spring.application.name}")
	private String name ;


	@RequestMapping(value = "/name")
	public String name(){
		return name;
	}
	@RequestMapping(value = { "/hello", "/" }) 
	public String hello() 
	{ 
		return "Hello World";
	}
}
