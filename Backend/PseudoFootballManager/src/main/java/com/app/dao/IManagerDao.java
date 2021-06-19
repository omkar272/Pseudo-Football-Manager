package com.app.dao;

import java.util.List;

import com.app.pojos.Player;

public interface IManagerDao {

	public List<Player>getTeamPlayer(int UserId) throws Exception;

	List<Player> getUnsoldPlayer() throws Exception;

	void purchasePlayer(int userId, int playerId) throws Exception;

	void relasePlayer(int playerId) throws Exception;
}
