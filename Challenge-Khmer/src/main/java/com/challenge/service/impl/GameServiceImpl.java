package com.challenge.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.GameDao;
import com.challenge.domain.Game;
import com.challenge.service.definition.GameService;

@Transactional
public class GameServiceImpl implements GameService {
	
	@Inject
	private GameDao gameDao;

	public void addGame(Game game) {
		gameDao.createGame(game);

	}

	public void deleteGame(Game game) {
		gameDao.deleteGame(game);

	}

	public List<Game> getGames() {
		return gameDao.retrieveGames();
	}

	public void updateGame(String homeTeam, String visitingTeam,
			Timestamp startTime, String sport, Game game) {
		Game entity = gameDao.findGameByNamesTimeAndSport(homeTeam, visitingTeam, startTime, sport);
		if(entity != null){
			entity.setEndTime(game.getEndTime());
			entity.setHomeCity(game.getHomeCity());
			entity.setHomeTeam(game.getHomeTeam());
			entity.setPlace(game.getPlace());
			entity.setScheduledEndTime(game.getScheduledEndTime());
			entity.setScheduledStartTime(game.getScheduledStartTime());
			entity.setSport(game.getSport());
			entity.setStartTime(game.getStartTime());
			entity.setVisitingCity(game.getVisitingCity());
			entity.setVisitingName(game.getVisitingName());
		}
		
	}

}
