package com.challenge.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;

public class SergeCommand extends HystrixCommand<String> {
	
	

	protected SergeCommand(Setter setter) {
		super(setter);
		// TODO Auto-generated constructor stub
	}

//	@Override
	protected String run() throws Exception {
		String serge = "Serge";
		return serge;
	}
	
	public String getFallback(){
		return "John";
	}

}
