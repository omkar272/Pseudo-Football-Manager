package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.dao.UserDaoImpl;
import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;
	public UserServiceImpl() {
		System.out.println("public UserServiceImpl() Object gets Created");
	}
	@Override
	public Users authenticateUser(String email, String password) throws Exception {
		return userDao.authenticateUser(email, password);
	}
	@Override
	public String registerUser(Users u) throws Exception {
		return userDao.RegisterUser(u);
		
	}
	@Override
	public String registerPlayer(Player p) throws Exception {
		return userDao.RegisterPlayer(p);
	}
	
	@Override
	public void registerManager(Users u) throws Exception {
		this.userDao.registerManager(u);
		
	}
	
	@Override
	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	@Override
	public Player getPlayerInfo(int userId) throws Exception {
		// TODO Auto-generated method stub
		return this.userDao.getPlayerInfo(userId);
	}
	@Override
	public Team getTeamStatus(int teamId) throws Exception {
		return this.getTeamStatus(teamId);
	}
	
	
	

}
