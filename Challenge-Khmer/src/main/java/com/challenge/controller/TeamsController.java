package com.challenge.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.domain.Team;
import com.challenge.process.definition.TeamProcess;

/**
 * Controller that provides clients with Team related data.
 * 
 * @author serge.akoa.owona
 *
 */
@Controller
public class TeamsController {

	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Process class that is responsible to orchestrate data related to teams.
	 */
	@Inject
	private TeamProcess teamProcess;

	/**
	 * Create a new Team
	 */
	@RequestMapping(value = "/v1/Teams", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> createTeam(@RequestBody Team team) {
		if (logger.isInfoEnabled()) {
			logger.info("The following team is about to be created: " + team.getName());
		}

		teamProcess.addTeam(team);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/**
	 * Delete an existing team
	 */
	@RequestMapping(value = "/v1/Teams/{name}/{sport}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> deleteTeam(@PathVariable String name, @PathVariable String sport) {
		if (logger.isInfoEnabled()) {
			logger.info("The following team is about to be deleted : " + name);
		}

		teamProcess.removeTeam(new Team(name, sport));
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/**
	 * Update an existing team
	 */
	@RequestMapping(value = "/v1/Teams/{name}/{city}/{sport}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> updateTeam( @PathVariable String name,@PathVariable String city, @PathVariable String sport, @RequestBody Team team) {
		if (logger.isInfoEnabled()) {
			logger.info("The following team is about to be updated : " + team.getName());
		}

		teamProcess.updateTeam(name,city, sport, team);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/**
	 * Retrieves all teams
	 */
	@RequestMapping(value = "/v1/Teams", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Team> getAllTeams() {
		if (logger.isInfoEnabled()) {
			logger.info("retrieves all teams");
		}

		return teamProcess.retrieveAllTeams();

	}

	/**
	 * Returns the list of teams sorted by sport type.
	 * 
	 */
	@RequestMapping(value = "v1/TeamsBySportType", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, List<Team>> retrieveTeamsBySportType() {
		if (logger.isInfoEnabled()) {
			logger.info("start retrieving a sorted list of teams by sport Type");
		}
		
		Map<String, List<Team>> map = teamProcess.retrieveTeamsBySportType();
		return map;

	}

}
