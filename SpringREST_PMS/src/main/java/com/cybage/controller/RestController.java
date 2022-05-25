package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@org.springframework.web.bind.annotation.RestController
public class RestController {


		@RequestMapping("/sayHello1")
		public String sayHello() {
			return " hello from spring rest 3";
			//we are returning string so it will search for this template like we did in model and view sending view as string
			// but now we are rest service so we want to send string as response not as view page so we use @response annotation
		}
		@RequestMapping("/data1")
		public  ResponseEntity<List<String>> listData() {
			List<String> list = new ArrayList<String>();
			list.add("one");
			list.add("hello");
			list.add("bye");
			
			//return list;
			return new ResponseEntity<>(list,HttpStatus.OK);

			
		}
		
		// getting data from header like ip add 
		public ResponseEntity<String> sayHello2()
		{
			return new ResponseEntity<>("hello from spring rest", HttpStatus.OK);
		}
		
		}

