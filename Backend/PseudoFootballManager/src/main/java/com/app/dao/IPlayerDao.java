package com.app.dao;

import java.util.List;

import com.app.pojos.Match;
import com.app.pojos.Player;
import com.app.pojos.Users;

public interface IPlayerDao {

	public Player getProfile(int userId) throws Exception;

}
