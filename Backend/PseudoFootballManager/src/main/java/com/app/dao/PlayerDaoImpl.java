package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.pojos.Match;
import com.app.pojos.MatchStatus;
import com.app.pojos.Player;
import com.app.pojos.Users;

@Repository
@Service
@Transactional
public class PlayerDaoImpl implements IPlayerDao {
	@Autowired
	private EntityManager Manager;

	@Override
	public Player getProfile(int userId) throws Exception {
		try {
			Player p1= new Player();
			String jpql= "select p from Player p";
			List<Player> p= this.Manager.createQuery(jpql, Player.class).getResultList();
			for (Player player : p) {
				if(player.getUser().getUserId()==userId)
				{
					p1=player;
				}
			}
			return p1;
			}
		catch(Exception e)
		{
			System.out.println("exception raised "+e.getMessage());
			throw new Exception();
		}
	}

	
}
