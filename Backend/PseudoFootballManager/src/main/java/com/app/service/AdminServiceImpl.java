package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.pojos.Ground;
import com.app.pojos.Match;
import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;
	
	public AdminServiceImpl() {
		System.out.println("public AdminServiceImpl()");
	}

	@Override
	public List<Team> getTeams() throws Exception{
		
		return adminDao.getTeams();
	}

	@Override
	public List<Ground> getGrounds() throws Exception{
		return adminDao.getGrounds();
	}

	@Override
	public String sheduleMatch(Match m) throws Exception{
		return adminDao.scheduleMatch(m);
	}

	@Override
	public List<Match> getScheduledMatches() throws Exception {
		return this.adminDao.getScheduledMatches();
	}

	@Override
	public void deleteScheduledMatch(int matchId) throws Exception {
			this.adminDao.deleteScheduledMatch(matchId);
	}

	@Override
	public void startScheduledMatch(int matchId) throws Exception {
		this.adminDao.startScheduledMatch(matchId);
		
	}

	@Override
	public Match getEditedMatch(int matchId) throws Exception{
		return adminDao.getEditedMatch(matchId);
		
	}

	@Override
	public String updateSheduleOfMatch(Match m) throws Exception {
		return adminDao.updateScheduleOfMatch(m);
	}

	@Override
	public List<Match> getLiveMatches() throws Exception {
		return adminDao.getLiveMatches();
	}
	
	@Override
	public List<Match> getFinishedMatches() throws Exception {
		return this.adminDao.getFinishedMatches();
	}

	@Override
	public List<Team> getTeamList() throws Exception {
		return this.adminDao.getTeamList();
	}

	@Override
	public void updateScoreOfTeam(int matchId, int teamId) throws Exception {
			this.adminDao.updateScoreOfTeam(matchId, teamId);
	}

	@Override
	public void finishMatch(int matchId) throws Exception {
		this.adminDao.finishMatch(matchId);
		
	}
	@Override
	public List<Player> showRegisteredPlayer() throws Exception{
		return this.adminDao.showRegisteredPlayer();
	}

	@Override
	public Users getAdminProfile(int userId) throws Exception {
		return this.adminDao.getAdminProfile(userId);
	}

	@Override
	public void allowPlayerForLeague(int playerId) throws Exception {
		this.adminDao.allowPlayerForLeague(playerId);
	}

	@Override
	public void notallowPlayerForLeague(int playerId) throws Exception {
		this.adminDao.notallowPlayerForLeague(playerId);
		
	}

	@Override
	public List<Player> getPlayerList(int teamId) throws Exception {
		// TODO Auto-generated method stub
		return this.adminDao.getPlayerList(teamId);
	}

	@Override
	public List<Team> getRegisteredTeamList() throws Exception {
		return this.adminDao.getRegisteredTeamList();
	}

	@Override
	public void allowTeam(int teamId) throws Exception {
		 this.adminDao.allowTeam(teamId);
	}
}
