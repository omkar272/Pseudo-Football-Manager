package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IManagerDao;
import com.app.pojos.Player;

@Service
@Transactional
public class ManagerServiceImpl implements IManagerService{

	@Autowired
	private IManagerDao managerDao;
	
	@Override
	public List<Player> getTeamPlayer(int UserId) throws Exception {
		return this.managerDao.getTeamPlayer(UserId);
	}
	
	@Override
	public List<Player>getUnsoldPlayer() throws Exception{
		return this.managerDao.getUnsoldPlayer();
	}
	
	@Override
	public void purchasePlayer(int userId,int playerId) throws Exception
	{
		this.managerDao.purchasePlayer(userId, playerId);
	}

	@Override
	public void relasePlayer(int playerId) throws Exception {
		this.managerDao.relasePlayer(playerId);
	}
}
