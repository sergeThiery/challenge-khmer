package com.challenge.hystrix.commands;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CommandCaller {
	
	public void callCommand(){
		SergeCommand sergeCommand = new SergeCommand(null);
		
		Future<String> sergeFuture = sergeCommand.queue();
		
		try {
			sergeFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Loggign
			e.printStackTrace();
		}
	}

}
