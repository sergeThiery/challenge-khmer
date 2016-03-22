package com.challenge.process.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.challenge.domain.Team;
import com.challenge.process.definition.TeamProcess;
import com.challenge.service.definition.TeamService;

/**
 * Process Implementation that retrieves information from a service.
 * 
 * @author serge.akoa.owona
 *
 */
public class TeamProcessImpl implements TeamProcess {
	/**
	 * Logger
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Service that retrieves Team Information
	 */
	@Inject
	private TeamService teamService;

	/**
	 * @Overwrite
	 */
	public void addTeam(Team team) {
		teamService.addTeam(team);

	}

	/**
	 * @Overwrite
	 */
	public void removeTeam(Team team) {
		teamService.deleteTeam(team);

	}

	/**
	 * @Overwrite
	 */
	public void updateTeam(String name,String city,String sport, Team team) {
		teamService.updateTeam(name, city,sport,team);

	}

	/**
	 * @Overwrite
	 */
	public Map<String, List<Team>> retrieveTeamsBySportType() {
		Map<String, List<Team>> teamMap = new HashMap<String, List<Team>>();
		List<Team> teams = teamService.getAllTeams();

		for (Team team : teams) {
			if (teamMap.containsKey(team.getSportType())) {
				List<Team> listOfTeams = teamMap.get(team.getSportType());
				listOfTeams.add(team);
			} else {
				List<Team> listOfTeams = new ArrayList<Team>();
				listOfTeams.add(team);
				teamMap.put(team.getSportType(), listOfTeams);
			}

		}
		return teamMap;
	}

	/**
	 * 
	 */
	public List<Team> retrieveAllTeams() {
		return teamService.getAllTeams();
	}


}
