package com.challenge.controller;

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

import com.challenge.domain.Player;
import com.challenge.process.definition.PlayerProcess;

/**
 * Controller class that exposes Player resources.
 * @author serge.akoa.owona
 *
 */
@Controller
public class PlayerController {
	
	/**
	 * Logger to log messages
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Process class that is responsible to orchestrate data related to players.
	 */
	@Inject
	private PlayerProcess playerProcess;

	
	@RequestMapping(value = "/v1/players", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> addPlayer(@RequestBody Player player) {
		if (logger.isInfoEnabled()) {
			logger.info("adding a new Player");
		}

		playerProcess.addPlayer(player);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}


	@RequestMapping(value = "/v1/players/{firstName}/{lastName}/{phone}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> deletePlayer(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String phone) {
		if (logger.isInfoEnabled()) {
			logger.info("removing  an existing  player");
		}
        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setPhone(phone);
		playerProcess.deletePlayer(player);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}


	@RequestMapping(value = "/v1/players/{firstName}/{lastName}/{phone}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> updatePlayer(@PathVariable String firstName, @PathVariable String lastName,@PathVariable String phone,  @RequestBody Player player) {
		if (logger.isInfoEnabled()) {
			logger.info("updating an existing player");
		}

		playerProcess.updatePlayer(firstName, lastName, phone,player);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/v1/players", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Player> getPlayers() {
		if (logger.isInfoEnabled()) {
			logger.info("get all players");
		}

		return playerProcess.getPlayers();

	}


}
