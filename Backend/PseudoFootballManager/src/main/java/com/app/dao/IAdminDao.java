package com.app.dao;

import java.util.List;

import com.app.pojos.Ground;
import com.app.pojos.Match;
import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;

public interface IAdminDao {

	public List<Team> getTeams() throws Exception;
	
	public List<Ground> getGrounds() throws Exception;
	
	public String scheduleMatch(Match m)throws Exception;
	
	public List<Match> getScheduledMatches()throws Exception;
	
	public void deleteScheduledMatch(int matchId)throws Exception;

	public void startScheduledMatch(int matchId)throws Exception;
	
	public Match getEditedMatch(int matchId)throws Exception;
	
	public String updateScheduleOfMatch(Match m)throws Exception;
	
	public List<Match> getLiveMatches()throws Exception;
	
	public List<Match> getFinishedMatches() throws Exception;
	
	public List<Team> getTeamList()throws Exception;
	
	public void updateScoreOfTeam(int matchId, int teamId) throws Exception;
	
	public void finishMatch(int matchId) throws Exception;
	
	public List<Player> showRegisteredPlayer() throws Exception;
	
	public Users getAdminProfile(int userId)throws Exception;

	public void allowPlayerForLeague(int playerId) throws Exception;

	public void notallowPlayerForLeague(int playerId) throws Exception;
	
	public List<Player>getPlayerList(int teamId)throws Exception;

	public List<Team> getRegisteredTeamList()throws Exception;

	public void allowTeam(int teamId) throws Exception;
	
	
}
