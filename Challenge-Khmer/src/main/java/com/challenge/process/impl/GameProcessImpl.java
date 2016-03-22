package com.challenge.process.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.challenge.domain.Game;
import com.challenge.process.definition.GameProcess;
import com.challenge.service.definition.GameService;

public class GameProcessImpl implements GameProcess {
	
	@Inject
	private GameService gameService;
	

	public void addGame(Game game) {
		gameService.addGame(game);

	}

	public void removeGame(Game game) {
		gameService.deleteGame(game);

	}

	public void updateGame(String homeTeam, String visitingTeam, Timestamp startTime, String sport, Game game) {
		gameService.updateGame(homeTeam, visitingTeam, startTime, sport, game);

	}

	public List<Game> retrieveGames() {
		return gameService.getGames();
	}

}
