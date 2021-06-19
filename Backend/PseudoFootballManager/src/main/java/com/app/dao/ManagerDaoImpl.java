package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.AllowedFlag;
import com.app.pojos.Player;
import com.app.pojos.PlayerStatus;
import com.app.pojos.Users;

@Repository
public class ManagerDaoImpl implements IManagerDao {

	@Autowired
	private EntityManager Manager;
	
	@Override
	public List<Player>getTeamPlayer(int UserId) throws Exception{
		try {
			System.out.println("user id "+UserId);
			Users u=this.Manager.find(Users.class, UserId);
			String jpql="select p from Player p where p.user.team.teamId=:teamId";
			List<Player> players= this.Manager.createQuery(jpql, Player.class).setParameter("teamId",u.getTeam().getTeamId()).getResultList();
			return players;
		}
		catch(Exception e)
		{
			throw new Exception();
		}
		}
	
	@Override
	public List<Player>getUnsoldPlayer() throws Exception{
		try {
			String jpql ="select p from Player p where p.playerStatus=:playerStatus and p.playerAllowedFlag=:playerAllowedFlag";
			List<Player>players=this.Manager.createQuery(jpql, Player.class).setParameter("playerStatus",PlayerStatus.Unsold).setParameter("playerAllowedFlag",AllowedFlag.Allowed).getResultList();
			return players;
		}
		catch(Exception e)
		{
			throw new Exception();
		}
	}

	@Override
	public void purchasePlayer(int userId,int playerId) throws Exception
	{
		try {
			System.out.println("userId "+userId );
				Users u=this.Manager.find(Users.class, userId);
			
				Player player= this.Manager.find(Player.class, playerId);
				player.setPlayerStatus(PlayerStatus.Sold);
				player.getUser().setTeam(u.getTeam());
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new Exception();
		}	
	}
			
			@Override
			public void relasePlayer(int playerd) throws Exception
			{
				try {
					Player p=this.Manager.find(Player.class, playerd);
					p.setPlayerStatus(PlayerStatus.Unsold);
					p.getUser().setTeam(null);
					this.Manager.merge(p);
					}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					throw new Exception();
				}	
			}
	
}












