package com.challenge.process.impl;

import java.util.List;

import javax.inject.Inject;

import com.challenge.domain.Player;
import com.challenge.process.definition.PlayerProcess;
import com.challenge.service.definition.PlayerService;

public class PlayerProcessImpl implements PlayerProcess {

	@Inject
	private PlayerService playerService;

	public void addPlayer(Player player) {
		playerService.addPlayer(player);

	}

	public void deletePlayer(Player player) {
		playerService.deletePlayer(player);

	}

	public void updatePlayer(String firstName, String lastName, String phone,Player player) {
		playerService.updatePlayer(firstName, lastName, phone, player);

	}

	public List<Player> getPlayers() {
		return playerService.getPlayers();
	}

}
