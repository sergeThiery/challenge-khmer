package com.challenge.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.TeamDao;
import com.challenge.domain.Team;
import com.challenge.hystrix.commands.TeamCommand;
import com.challenge.service.definition.TeamService;
/**
 * 
 * @author serge.akoa.owona
 *
 */
@Transactional
public class TeamServiceImpl implements TeamService {
	
	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * The Dao class to retrieve Teams related information
	 */
	@Inject
	private TeamDao teamDao;
	
   @Inject
	private TeamCommand teamCommand;
	

	/**
	 * 
	 */
	public List<Team> getAllTeams() {
		List<Team> teams = teamDao.retrieveAllTeams();
		
//		Future<List<Team>> futureTeams = (Future<List<Team>>) teamCommand.queue();
//		
//		try {
//			teams =  futureTeams.get();
//		} catch (InterruptedException e) {
//			logger.error("the future was interrupted");
//		} catch (ExecutionException e) {
//			logger.error("execution of the get method of the thread was subject to an exception: " + e);
//		}	
		return teams;
	}
	
	
	/**
	 * 
	 */
	public void addTeam(Team team) {
		teamDao.createTeam(team);
		
	}

	/**
	 * 
	 */
	public void deleteTeam(Team team) {
		teamDao.deleteTeam(team);
		
	}
	
	/**
	 * 
	 */
	public Team getTeam(String name, String city, String code) {
		return teamDao.getTeam(name, city, code);
	}

	/*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
	public void updateTeam(String name, String city, String sport, Team team) {
		Team entity = teamDao.getTeam(name, city, sport);
	        if(entity!=null){
	            entity.setCity(team.getCity());
	            entity.setHeadCoach(team.getHeadCoach());
	            entity.setName(team.getName());
	            entity.setSportType(team.getSportType());
	            entity.setState(team.getState());
	            entity.setTeamType(team.getTeamType());
	        }
		
	}

}
