package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.League;
import com.app.pojos.Player;
import com.app.pojos.Role;
import com.app.pojos.Team;
import com.app.pojos.Users;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	EntityManager Manager;

	public UserDaoImpl() {
		System.out.println("public UserDaoImpl() Object gets Created");	
		}
	
	@Override
	public String RegisterUser(Users u) throws Exception {
			System.out.println("I am in dao");
		try {
			//String jpql="select t from Team t where t.teamAllowedFlag=:teamAllowedFlag";
			String jpql="select u from Users u where u.userRole=:role";
			int count =0;
			//count =(Integer)this.Manager.createQuery(jpql).setParameter("role",Role.Admin).getSingleResult();
			///Users u1 =(Users) this.Manager.createNativeQuery(jpql).setParameter("role",Role.Admin);
			Users u2= this.Manager.createQuery(jpql,Users.class).setParameter("role", Role.Admin).getSingleResult();
			//throw new Exception("Admin Registration not allowed");
			return "Admin Registration not allowed";
		}catch(Exception e)
		{	Manager.persist(u);
			throw new Exception();
		}
	}

	@Override
	public Users authenticateUser(String email, String password) throws Exception {
		
		try {
		String jpql = "select u from Users u where email=:email and password=:password";
		return Manager.createQuery(jpql, Users.class).setParameter("email",email)
				.setParameter("password", password).getSingleResult();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	@Override
	public String RegisterPlayer(Player p) throws Exception {
		try {
			System.out.println("request");
			//p.getUser().getTeam().setTeamId(0);
			Manager.persist(p);
			return "Successfully Done Registration";
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}
	
	@Override
	public Users findByEmail(String email)
	{
		String jpql = "select u from Users u where email=:email";
		return Manager.createQuery(jpql, Users.class).setParameter("email",email).getSingleResult();
	}

	@Override
	public Player getPlayerInfo(int userId) throws Exception {
		try {
		String jpql="select p from Player p where p.user.userId=:userId";
		Player p= Manager.createQuery(jpql, Player.class).setParameter("userId", userId).getSingleResult();
		return p;
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
		throw new Exception();
	}
		
	}

	@Override
	public void registerManager(Users u) throws Exception {
	
		try {
			Manager.persist(u);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new Exception();
		}
		
	}

	@Override
	public Team getTeamStatus(int teamId) throws Exception {
		try {
			Team t=this.Manager.find(Team.class, teamId);
			return t;
		}
		catch(Exception e)
		{
			throw new Exception();
		}
		
	}
	
	
	
	
}
