package com.challenge.dao;

import java.sql.Timestamp;
import java.util.List;

import com.challenge.domain.Game;

public interface GameDao {
	
  void createGame(Game game);
  
  void deleteGame (Game game);
  
  List<Game> retrieveGames();
  
  Game findGameByNamesTimeAndSport(String homeTeam, String visitingTeam, Timestamp startTime, String sport);
  
}
