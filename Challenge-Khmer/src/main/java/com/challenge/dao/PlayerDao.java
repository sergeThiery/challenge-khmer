package com.challenge.dao;

import java.util.List;

import com.challenge.domain.Player;

public interface PlayerDao {
	 
    void savePlayer(Player player);
     
    void deletePlayerByNamesAndPhone(Player player);
     
    List<Player> findAllPlayers();
 
    Player findPlayerByNamesAndPhone(String firstName, String lastName, String phone);
 

}
