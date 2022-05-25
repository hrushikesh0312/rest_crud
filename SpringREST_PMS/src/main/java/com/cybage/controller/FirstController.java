// this is using spring 3 
package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

	@RequestMapping("/sayHello")
	@ResponseBody // used to send data as response
	public String sayHello() {
		return " hello from spring rest 3";
		//we are returning string so it will search for this template like we did in model and view sending view as string
		// but now we are rest service so we want to send string as response not as view page so we use @response annotation
	}
	@RequestMapping("/data")
	@ResponseBody 
	public List<String> listData() {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("hello");
		list.add("bye");
		
		return list;
		
	}
}
//here if we add 50 method we have to add response body to each method hence to reduce this spring 4 introduced RESTCONTROLLER
// if your class is annotated with rest controller annotation then you dont have to add response body to each method
// see restController controller 