package com.challenge.service.definition;

import java.util.List;

import com.challenge.domain.Player;

public interface PlayerService {
	
	void addPlayer(Player player);
	
	void deletePlayer (Player player);
	
	void updatePlayer (String firstName, String lastName, String phone,Player player);
	
	List<Player> getPlayers();

}
