package com.challenge.soccer.domain;

import java.util.ArrayList;
import java.util.List;

import com.challenge.domain.Card;
import com.challenge.domain.Game;
import com.challenge.domain.Referee;
import com.challenge.domain.Team;

public class SoccerGame extends Game {

	private Team team1;

	private Team team2;

	private List<Referee> referees = new ArrayList<Referee>();

	private List<Card> cards = new ArrayList<Card>();

	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(Card card){
		this.cards.remove(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Referee> getReferees() {
		return referees;
	}

	public void setReferees(List<Referee> referees) {
		this.referees = referees;
	}

	private SoccerGame(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public void removeReferee(Referee referee) {
		this.referees.remove(referee);
	}

	public void addReferee(Referee referee) {
		if (referees.size() > 3) {
			throw new RuntimeException("A soccerGame can only have 3 referees");
		}
		this.referees.add(referee);
	}

}
