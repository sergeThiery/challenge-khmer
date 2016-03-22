package com.challenge.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.dao.TeamDao;
import com.challenge.domain.Team;

@Transactional
public class TeamDaoImpl extends AbstractDao<Integer, Team> implements TeamDao {

	public void createTeam(Team team) {
		persist(team);
	}

	public void deleteTeam(Team team) {
		Query query = getSession().createSQLQuery("delete from teams where name = :name");
        query.setString("name", team.getName());
        query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Team> retrieveAllTeams() {
		Criteria criteria = createEntityCriteria();
        return (List<Team>) criteria.list();
		
	}

	public Team getTeam(String name, String city, String sportType) {
		 Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("name", name));
	        criteria.add(Restrictions.eq("city", city));
	        return (Team) criteria.uniqueResult();
	}

}
