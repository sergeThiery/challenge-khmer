package com.challenge.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.PlayerDao;
import com.challenge.domain.Player;
import com.challenge.service.definition.PlayerService;

@Transactional
public class PlayerServiceImpl implements PlayerService {
	
	@Inject
	private PlayerDao playerDao;

	public void addPlayer(Player player) {
		playerDao.savePlayer(player);

	}

	public void deletePlayer(Player player) {
      playerDao.deletePlayerByNamesAndPhone(player);
	}

	public void updatePlayer(String firstName, String lastName, String phone, Player player) {
		Player entity = playerDao.findPlayerByNamesAndPhone(firstName, lastName, phone);
        if(entity!=null){
            entity.setAddress(player.getAddress());
            entity.setFirstName(player.getFirstName());
            entity.setLastName(player.getLastName());
            entity.setPhone(player.getPhone());
            entity.setCity(player.getCity());
            entity.setState(player.getState());
            entity.setAge(player.getAge());
            entity.setHeight(player.getHeight());
            entity.setWeight(player.getWeight());

        }

	}

	public List<Player> getPlayers() {

		return playerDao.findAllPlayers();
	}

}
