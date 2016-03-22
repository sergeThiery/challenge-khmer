package com.challenge.service.definition;

import java.sql.Timestamp;
import java.util.List;

import com.challenge.domain.Game;

public interface GameService {
 
	void addGame (Game game);
	
	void deleteGame(Game game);
	
	void updateGame(String homeTeam, String visitingTeam,
			Timestamp startTime, String sport, Game game);
	
	List<Game> getGames();
	 
}
