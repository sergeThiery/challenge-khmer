package com.challenge.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAMES")
public class Game implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "scheduledStartTime")
	private Timestamp scheduledStartTime;

	@Column(name = "starTime")
	private Timestamp startTime;

	@Column(name = "scheduledEndTime")
	private Timestamp scheduledEndTime;

	@Column(name = "endTime")
	private Timestamp endTime;
	
	@Column(name = "place")
	private String place;
	
	@Id
	@Column(name = "homeTeam")
	private String homeTeam;
	
	@Column(name = "homeCity")
	private String homeCity;
	
	@Column(name = "sport")
	private String sport;
	
	@Id
	@Column(name = "visitingTeam")
	private String visitingName;
	
	@Column(name = "visitingCity")
	private String visitingCity;
	
	public Game(){
		
	}
	
	
//	private List<Card> yellowCards = new ArrayList<Card>();
//	
//	private List<Card> redCards = new ArrayList<Card> ();

	public Timestamp getScheduledStartTime() {
		return scheduledStartTime;
	}

	public void setScheduledStartTime(Timestamp scheduledStartTime) {
		this.scheduledStartTime = scheduledStartTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getScheduledEndTime() {
		return scheduledEndTime;
	}

	public void setScheduledEndTime(Timestamp scheduledEndTime) {
		this.scheduledEndTime = scheduledEndTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getVisitingName() {
		return visitingName;
	}

	public void setVisitingName(String visitingName) {
		this.visitingName = visitingName;
	}

	public String getVisitingCity() {
		return visitingCity;
	}

	public void setVisitingCity(String visitingCity) {
		this.visitingCity = visitingCity;
	}

	public String getSport() {
		return sport;
	}


	public void setSport(String sport) {
		this.sport = sport;
	}


	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
