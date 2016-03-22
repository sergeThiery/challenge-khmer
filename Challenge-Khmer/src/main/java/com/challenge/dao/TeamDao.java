package com.challenge.dao;

import java.util.List;

import com.challenge.domain.Team;

public interface TeamDao {
	
	void createTeam(Team team);
	
	void deleteTeam(Team team);
	
	List<Team> retrieveAllTeams();
	
	Team getTeam(String name, String city, String sportType);

}
