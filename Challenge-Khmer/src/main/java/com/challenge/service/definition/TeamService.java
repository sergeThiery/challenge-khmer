package com.challenge.service.definition;

import java.util.List;

import com.challenge.domain.Team;

/**
 * Service to retrieve Team related Information
 * 
 * @author serge.akoa.owona
 *
 */
public interface TeamService {

	/**
	 * add a new Team
	 * 
	 * @param team
	 */
	void addTeam(Team team);

	/**
	 * deletes an existing team
	 * 
	 * @param team
	 */
	void deleteTeam(Team team);

	/**
	 * update an existing team
	 * 
	 * @param team
	 */
	void updateTeam(String name, String city, String sport, Team team);

	/**
	 * retrieves all teams
	 * 
	 * @return List of teams
	 */
	List<Team> getAllTeams();

	/**
	 * Retrieves a team
	 * 
	 * @param name
	 *            : Name of the team
	 * @param city
	 *            : city of the team
	 * @param code
	 *            : The sport type
	 * @return The corresponding team
	 */
	Team getTeam(String name, String city, String code);

}
