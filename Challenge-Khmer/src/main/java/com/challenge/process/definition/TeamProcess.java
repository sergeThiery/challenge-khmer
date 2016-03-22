package com.challenge.process.definition;

import java.util.List;
import java.util.Map;

import com.challenge.domain.SportType;
import com.challenge.domain.Team;

/**
 * Return Team Related Data.
 * @author serge.akoa.owona
 *
 */
public interface TeamProcess {
	
	/**
	 * retrieves a sorted list of teams by sport type.
	 * @return a sorted list of teams by sport type.
	 */
	Map<String, List<Team>> retrieveTeamsBySportType();
	
	/**
	 * retrieves all team
	 * @return List of all teams
	 */
	List<Team> retrieveAllTeams();
	
	/**
	 * add a new Team
	 * @param team to be added.
	 */
	void addTeam(Team team);

	/**
	 * removes the team
	 * @param team to be removed
	 */
	void removeTeam(Team team);

	/**
	 * updates existing team.
	 * @param team to be updated
	 */
	void updateTeam(String name, String city, String sport, Team team);

}
