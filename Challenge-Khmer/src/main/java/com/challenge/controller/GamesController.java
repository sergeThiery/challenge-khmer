package com.challenge.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.domain.Game;
import com.challenge.process.definition.GameProcess;

/**
 * Controller that put the Games resources at disposal for clients to consume.
 * @author serge.akoa.owona
 *
 */
@Controller
public class GamesController {

	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Process class that is responsible to orchestrate data related to games.
	 */
	@Inject
	private GameProcess gameProcess;

	/**
	 * insert
	 * 
	 */
	@RequestMapping(value = "/v1/games", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> updateGames(@RequestBody Game game) {
		if (logger.isInfoEnabled()) {
			logger.info("inserting new game");
		}

		gameProcess.addGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/**
	 * returns the list of teams
	 * 
	 * @return TeamOverview which contains the list of teams
	 */
	@RequestMapping(value = "/v1/games", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> deleteGame(@PathVariable Timestamp scheduledTime, @PathVariable String sport, @PathVariable String homeTeam, @PathVariable String visitingTeam ) {
		if (logger.isInfoEnabled()) {
			logger.info("removing  an existing game");
		}
        Game game = new Game();
        game.setScheduledStartTime(scheduledTime);
        game.setSport(sport);
        game.setHomeCity(homeTeam);
        game.setVisitingName(visitingTeam);
        
		gameProcess.removeGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/**
	 * returns the list of teams
	 * 
	 * @return TeamOverview which contains the list of teams
	 */
	@RequestMapping(value = "/v1/games/{homeTeam}/{visitingTeam}/{startTime}/{sport}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> insertGames(@PathVariable String homeTeam, @PathVariable String visitingTeam, @PathVariable Timestamp startTime, @PathVariable String sport, @RequestBody Game game) {
		if (logger.isInfoEnabled()) {
			logger.info("update an existing game");
		}

		gameProcess.updateGame(homeTeam, visitingTeam, startTime, sport, game);;
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/**
	 * returns the list of teams
	 * 
	 * @return TeamOverview which contains the list of teams
	 */
	@RequestMapping(value = "/v1/games", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Game> retrieveGames() {
		if (logger.isInfoEnabled()) {
			logger.info("retrieving games");
		}

		return gameProcess.retrieveGames();

	}

}
