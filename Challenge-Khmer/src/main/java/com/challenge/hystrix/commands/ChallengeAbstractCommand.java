package com.challenge.hystrix.commands;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netflix.hystrix.HystrixCommand;

public abstract class ChallengeAbstractCommand<R> extends HystrixCommand<R> {

	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	protected ChallengeAbstractCommand(Setter setter) {
		super(setter);
	}

	public abstract R challengeGetFallback();

	public R getFallback() {
		if (this.isFailedExecution()) {
			
			logger.warn("The execution of the command failed because of an issue during the execution of the risky functionality");

		} else if (this.isResponseRejected()) {
			logger.warn("The execution of the command did not happen because the request was rejected.");

		} else if (this.isResponseShortCircuited()) {
			logger.error("The execution of the command failed because the circuit breaker is tripped");

		} else if (this.isResponseTimedOut()) {
			logger.warn("The execution of the command failed because of a timeout");

		}
		return challengeGetFallback();
	}

}
