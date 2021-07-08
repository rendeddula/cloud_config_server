package com.manh.gms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

	@Autowired
	AsyncExecution ae;
	
	@GetMapping("/callAsync")
	public String callAsync() {
		ae.callAsync();
		return "Hello";
	}
	
}
