package com.challenge.process.definition;

import java.sql.Timestamp;
import java.util.List;

import com.challenge.domain.Game;

public interface GameProcess {
	
	void addGame(Game game);
	
	void removeGame(Game game);
	
	void updateGame(String homeTeam, String visitingTeam, Timestamp startTime, String sport, Game game);
	
	List<Game> retrieveGames();
	

}
