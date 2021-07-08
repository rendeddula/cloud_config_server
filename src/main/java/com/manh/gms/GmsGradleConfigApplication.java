package com.manh.gms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@EnableAsync
@RestController
public class GmsGradleConfigApplication {

	static int i = 0;
	
	public static void main(String[] args) {
		SpringApplication.run(GmsGradleConfigApplication.class, args);
	}
	
	@GetMapping("/testRestart")
	public String testRestart() {
		
		i++;
		
		if(i>5) {
			try {
				System.out.println("Stopping for 35 seconds");
				Thread.sleep(1000*35);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("No Wait Reply");
		}
		System.out.println("Replied");
		return "HEALTHY_SERVER";
	}

}
