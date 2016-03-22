package com.challenge.hystrix.commands;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.challenge.dao.TeamDao;
import com.challenge.domain.Team;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Hystrix Command that protects the platform against database failures when retrieving Teams from the database.
 * @author serge.akoa.owona
 *
 */
public class TeamCommand extends ChallengeAbstractCommand<List<Team>> {
	
	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Dao class that retrieve teams from the database.
	 */
	@Inject
	private TeamDao teamDao;
	

	/**
	 * Setter for the TeamCommand.
	 */
	private static HystrixCommand.Setter teamCommandSetter = HystrixCommand.Setter
			.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TeamGroup"));

	public TeamCommand() {
		super(teamCommandSetter);
	}

	/**
	 * run method where the risky functionality is implemented.
	 */
	@Override
	protected List<Team> run() throws Exception {
		return teamDao.retrieveAllTeams();
	}
	
	public List<Team> challengeGetFallback(){	
		return new ArrayList<Team>();
	}

}
