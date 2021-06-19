package com.app.dao;

import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;

public interface IUserDao {

	public String RegisterUser(Users u) throws Exception;
	public Users authenticateUser(String email, String pasword) throws Exception;
	public String RegisterPlayer(Player p) throws Exception;
	public Users findByEmail(String email);
	public Player getPlayerInfo(int userId) throws Exception;
	void registerManager(Users u) throws Exception;
	public Team getTeamStatus(int teamId) throws Exception;
}
