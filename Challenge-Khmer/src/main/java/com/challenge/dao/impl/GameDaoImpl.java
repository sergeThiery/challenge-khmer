package com.challenge.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.challenge.dao.GameDao;
import com.challenge.domain.Game;

public  class GameDaoImpl extends AbstractDao<Integer, Game> implements GameDao {

	public void createGame(Game game) {
		this.persist(game);

	}

	public void deleteGame(Game game) {
		Query query = getSession().createSQLQuery("delete from games where homeTeam = :homeTeam and visitingTeam = :visitingTeam and sport = :sport and starTime = :starTime");
        query.setString("homeTeam", game.getHomeTeam());
        query.setString("visitingTeam", game.getVisitingName());
        query.setString("sport", game.getSport());
        query.setTimestamp("starTime", game.getStartTime());
        query.executeUpdate();

	}

	public List<Game> retrieveGames() {
		Criteria criteria = createEntityCriteria();
        @SuppressWarnings("unchecked")
		List<Game> list = (List<Game>) criteria.list();
		return list;
	}

	public Game findGameByNamesTimeAndSport(String homeTeam,
			String visitingTeam, Timestamp startTime, String sport) {
		  Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("homeTeam", homeTeam));
	        criteria.add(Restrictions.eq("visitingTeam", visitingTeam));
	        criteria.add(Restrictions.eq("startTime", startTime));
	        criteria.add(Restrictions.eq("sport", sport));
	        return (Game) criteria.uniqueResult();
	}

	

}
