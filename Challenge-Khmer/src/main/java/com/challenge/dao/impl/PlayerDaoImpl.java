package com.challenge.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.challenge.dao.PlayerDao;
import com.challenge.domain.Player;

public class PlayerDaoImpl extends AbstractDao<Integer, Player> implements PlayerDao {


	public void savePlayer(Player player) {
		persist(player);

	}

	public void deletePlayerByNamesAndPhone(Player player) {
		Query query = getSession().createSQLQuery("delete from players where firstName = :firstName and lastName = :lastName and phone = :phone");
        query.setString("firstName", player.getFirstName());
        query.setString("lastName", player.getLastName());
        query.setString("phone", player.getPhone());
        query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Player> findAllPlayers() {
		Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
	}

	public Player findPlayerByNamesAndPhone(String firstName, String lastName, String phone) {
 
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("firstName", firstName));
        criteria.add(Restrictions.eq("lastName", lastName));
        criteria.add(Restrictions.eq("phone", phone));
  
        return (Player) criteria.uniqueResult();
	}

}
