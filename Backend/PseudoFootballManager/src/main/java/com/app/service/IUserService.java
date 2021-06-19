package com.app.service;

import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;

public interface IUserService {

	Users authenticateUser(String email, String password) throws Exception ;

	String registerUser(Users u) throws Exception ;

	String registerPlayer(Player p)throws Exception ;
	
	public Users findByEmail(String email) throws Exception ;
	
	public Player getPlayerInfo(int userId) throws Exception ;

	void registerManager(Users u) throws Exception;

	Team getTeamStatus(int teamId) throws Exception;
	
}
