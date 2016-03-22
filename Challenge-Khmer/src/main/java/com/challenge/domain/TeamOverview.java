package com.challenge.domain;

import java.util.ArrayList;
import java.util.List;

public class TeamOverview {
	
	private List<Team> teams = new ArrayList<Team>();
	
	public TeamOverview (List<Team> teams){
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}
