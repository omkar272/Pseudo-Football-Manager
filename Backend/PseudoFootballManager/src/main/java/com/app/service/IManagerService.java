package com.app.service;

import java.util.List;

import com.app.pojos.Player;

public interface IManagerService {

	public List<Player>getTeamPlayer(int UserId) throws Exception;

	List<Player> getUnsoldPlayer() throws Exception;

	void purchasePlayer(int userId, int playerId) throws Exception;
	
	public void relasePlayer(int playerd) throws Exception;
}
