package com.challenge.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Represents a team that takes place in a tournament.
 * 
 * @author serge.akoa.owona
 *
 */
@Entity
@Table(name = "TEAMS")
public class Team implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	/**
//	 * List of games that will be played by the team during a tournament
//	 */
//	private List<Game> games = new ArrayList<Game>();
//
//	/**
//	 * List of players that will be part of the team during the tournament.
//	 */
//	private List<Player> players = new ArrayList<Player>();
//	
	/**
	 * Name of the city.
	 */
	@Id
	@Size(min = 3, max = 50)
	@Column(name = "CITY", nullable = false)
	private String city;

	/**
	 * The type of sport the team does
	 */
	@Id
	@Column(name = "SPORT", nullable = false)
	private String sportType;

	/**
	 * The name of the team
	 */
	@Id
	@Size(min = 3, max = 50)
	@Column(name = "NAME", nullable = false)
	private String name;
	
	/**
	 * The state of the team
	 */
	@Size(min = 3, max = 20)
	@Column(name = "STATE", nullable = false)
	private String state;
	
	/**
	 * The type of the team; Male or Female
	 */
	@Size(min = 3, max = 10)
	@Column(name = "TeamType", nullable = false)
	private String teamType;
	
	/**
	 * The type of the team; Male or Female
	 */
	@Size(min = 1, max = 50)
	@Column(name = "HeadCoach", nullable = true)
	private String headCoach;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public String getHeadCoach() {
		return headCoach;
	}

	public void setHeadCoach(String headCoach) {
		this.headCoach = headCoach;
	}

	/**
	 * Constructor to create a team
	 * 
	 * @param name
	 *            The name of the team
	 * @param city
	 *            The city of the team
	 * @param sportType
	 *            The type of sport the team does.
	 *            
	 */
	public Team(String name, String city, String state, String sportType, String teamType, String headCoach) {
		this.name = name;
		this.city = city;
		this.sportType = sportType;
		this.state = state;
		this.teamType = teamType;
		this.headCoach = headCoach;
	}
	
	public Team(String name, String sport){
		this.name = name;
		this.sportType = sport;
	}
	
	public Team(){
		
	}

//	/**
//	 * Returns the list of games.
//	 * 
//	 * @return Lit of games.
//	 */
//	public List<Game> getGames() {
//		return games;
//	}
//
//	/**
//	 * Sets the list of games.
//	 * 
//	 * @param games
//	 *            List of games
//	 */
//	public void setGames(List<Game> games) {
//		this.games = games;
//	}
//
//	/**
//	 * Get the list of players.
//	 * 
//	 * @return the list of players
//	 */
//	public List<Player> getPlayers() {
//		return players;
//	}

//	/**
//	 * Sets the list of players
//	 * 
//	 * @param players
//	 */
//	public void setPlayers(List<Player> players) {
//		this.players = players;
//	}

	/**
	 * Returns the name f the team
	 * 
	 * @return the name of the team
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the team
	 * 
	 * @param name
	 *            of the team
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the city
	 * 
	 * @return the name of the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the name of the city
	 * 
	 * @param city
	 *            of the team
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}


//	public void addPlayer(Player player) {
//		this.players.add(player);
//	}
//
//	public void removePlayer(Player player) {
//		this.players.remove(player);
//	}

}
