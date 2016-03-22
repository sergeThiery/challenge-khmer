package com.challenge.hystrix.commands;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandFactory {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"");

	public static TeamCommand getTeamCommand(DB_OPERATION_TYPE operationType) {

		return (TeamCommand) applicationContext.getBean("teamCommand", operationType);
	}

}
