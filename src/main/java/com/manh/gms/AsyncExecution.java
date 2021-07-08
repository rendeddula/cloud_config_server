package com.manh.gms;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncExecution {

	@Async
	public CompletableFuture<Boolean> callAsync() {
		this.pauseExecution();
		
		return CompletableFuture.completedFuture(true);
	}
	
	public synchronized void pauseExecution() {
		try {
			System.out.println("Working time :: "+new Date());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
