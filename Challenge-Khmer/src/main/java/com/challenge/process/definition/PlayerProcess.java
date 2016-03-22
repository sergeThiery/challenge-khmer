package com.challenge.process.definition;

import java.util.List;

import com.challenge.domain.Player;

public interface PlayerProcess {
	
	void addPlayer(Player player);
	
	void deletePlayer(Player player);
	
	void updatePlayer(String firstName, String lastName, String phone, Player player);
	
	List<Player> getPlayers();

}
