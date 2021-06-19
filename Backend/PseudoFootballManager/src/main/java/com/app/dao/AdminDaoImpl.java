package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Ground;
import com.app.pojos.Match;
import com.app.pojos.MatchStatus;
import com.app.pojos.Player;
import com.app.pojos.AllowedFlag;
import com.app.pojos.PlayerStatus;
import com.app.pojos.Team;
import com.app.pojos.Users;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private EntityManager Manager;

	public AdminDaoImpl() {
		System.out.println("public AdminDaoImpl()");
	}

	@Override
	public List<Team> getTeams() throws Exception {
		try {
			String jpql="select t from Team t where t.teamAllowedFlag=:teamAllowedFlag";
			List<Team> teams=Manager.createQuery(jpql,Team.class).setParameter("teamAllowedFlag",AllowedFlag.Allowed).getResultList();
			return teams;
		}
		catch(Exception e)
		{
			throw new Exception();
		}
	}

	@Override
	public List<Ground> getGrounds() throws Exception {
		try {
		String jpql="select g from Ground g";
		List<Ground> grounds=Manager.createQuery(jpql,Ground.class).getResultList();
		return grounds;
		}
		catch(Exception e)
		{
			throw new Exception();
		}
	}
	
	@Override
	public String scheduleMatch(Match m) throws Exception {
		try {
			Manager.persist(m);
			
			return "Match Scheduled Successfully";
		}
		catch(Exception e )
		{
			System.out.println("error massge "+e.getMessage());
			throw new Exception();
		}
	}

	@Override
	public List<Match> getScheduledMatches() throws Exception {
		try {
		MatchStatus m=MatchStatus.Featured;
		String jpql= "select m from Match m where m.matchStatus=:matchStatus";
		List<Match>matches=Manager.createQuery(jpql,Match.class).setParameter("matchStatus",m).getResultList();
		//System.out.println("dao matches "+matches);
		for (Match match : matches) {
			System.out.println("match"+match.getMatchId());
		}
		return matches;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	@Override
	public void deleteScheduledMatch(int matchId) throws Exception {
			try {
			Match m=Manager.find(Match.class, matchId);
			Manager.remove(m);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				throw new Exception();
			}
	}

	@Override
	public void startScheduledMatch(int matchId) throws Exception {
		try {
			Match m=Manager.find(Match.class, matchId);
			m.setMatchStatus(MatchStatus.Playing);
			System.out.println(m.getMatchId());
			Manager.merge(m);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				throw new Exception();
			}
	}

	@Override
	public Match getEditedMatch(int matchId) throws Exception {
		
		try {
			System.out.println("public Match getEditedMatch(int matchId)");
			Match m=Manager.find(Match.class, matchId);
				return m;
			}
			catch(Exception e)
			{
				
				System.out.println(e.getMessage());
				throw new Exception();
			}

	}

	@Override
	public String updateScheduleOfMatch(Match m) throws Exception {
		try {
				Manager.merge(m);
			
			return "Match Scheduled Successfully";
		}
		catch(Exception e )
		{
			System.out.println("error massge "+e.getMessage());
			throw new Exception();
		}
	}

	@Override
	public List<Match> getLiveMatches() throws Exception {
		try {
			MatchStatus m=MatchStatus.Playing;
			String jpql= "select m from Match m where m.matchStatus=:matchStatus";
			List<Match>matches=Manager.createQuery(jpql,Match.class).setParameter("matchStatus",m).getResultList();
			//System.out.println("dao matches "+matches);
			
			return matches;
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				throw new Exception();
			}
	}
	
	
	@Override
	public List<Match> getFinishedMatches() throws Exception {
		try {
			MatchStatus m=MatchStatus.Played;
			String jpql= "select m from Match m where m.matchStatus=:matchStatus";
			List<Match>matches=Manager.createQuery(jpql,Match.class).setParameter("matchStatus",m).getResultList();
			//System.out.println("dao matches "+matches);
			
			return matches;
			}
			
			catch(Exception e)
			{
				throw new Exception();
			}
	}

	@Override
	public List<Team> getTeamList() throws Exception{
		try {
			String jpql="select t from Team t where t.teamAllowedFlag=:teamAllowedFlag";
			 List<Team>teams= Manager.createQuery(jpql, Team.class).setParameter("teamAllowedFlag", AllowedFlag.Allowed).getResultList();
			 return teams;
		}
		catch(Exception e) {
			throw new Exception();
		}
	}
	
	@Override
	public List<Team> getRegisteredTeamList() throws Exception {
		try {
			String jpql="select t from Team t where t.teamAllowedFlag=:teamAllowedFlag";
			 List<Team>teams= Manager.createQuery(jpql, Team.class).setParameter("teamAllowedFlag", AllowedFlag.NotAllowed).getResultList();
			
			 return teams;
		}
		catch(Exception e) {
			throw new Exception();
		}
	}

	@Override
	public void updateScoreOfTeam(int matchId, int teamId) throws Exception {
		try{
			Match m=Manager.find(Match.class,matchId);
		
		if(teamId==1)
		{
			m.setFirstTeamScore(m.getFirstTeamScore()+1);
		}
		else if(teamId==2)
		{
			m.setSecondTeamScore(m.getSecondTeamScore()+1);
		}
		
		else {
			throw new Exception("Something Went Wrong");
		}
		Manager.merge(m);
		}
		catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public void finishMatch(int matchId) throws Exception {
			try {
				Match m=Manager.find(Match.class,matchId);
				m.setMatchStatus(MatchStatus.Played);
				Team t1=Manager.find(Team.class,m.getFirstTeam().getTeamId());
				Team t2= Manager.find(Team.class, m.getSecondTeam().getTeamId());
				if(m.getFirstTeamScore()>m.getSecondTeamScore())
				{	
					t1.setNoOfWin(t1.getNoOfWin()+1);
					t2.setNoOfLose(t2.getNoOfLose()+1);
					t1.setTotalScore(t1.getTotalScore()+2);
				}
				else if(m.getFirstTeamScore()<m.getSecondTeamScore())
				{
					t1.setNoOfLose(t1.getNoOfLose()+1);
					t2.setNoOfWin(t2.getNoOfWin()+1);
					t2.setTotalScore(t1.getTotalScore()+2);
					
				}
				else if(m.getFirstTeamScore()==m.getSecondTeamScore())
				{
					t1.setNoOfDraws(t1.getNoOfDraws()+1);
					t2.setNoOfDraws(t2.getNoOfDraws()+1);
					t1.setTotalScore(t1.getTotalScore()+1);
					t2.setTotalScore(t1.getTotalScore()+1);
				}
				t1.setNoOfMatchPlayed(t1.getNoOfMatchPlayed()+1);
				t2.setNoOfMatchPlayed(t2.getNoOfMatchPlayed()+1);
				t1.setNoOfGoals(t1.getNoOfGoals()+m.getFirstTeamScore());
				t2.setNoOfGoals(t2.getNoOfGoals()+m.getFirstTeamScore());
				Manager.merge(m);
				Manager.merge(t1);
				Manager.merge(t2);
				}
			catch(Exception e) {
			throw new Exception(e.getMessage());	
			}
		
	}

	@Override
	public List<Player> showRegisteredPlayer() throws Exception {
		try {
			//String jpql= "select m from Match m where m.matchStatus=:matchStatus";
		String jpql="select p from Player p where p.playerStatus=:playerStatus";
		System.out.println(jpql);
		List<Player> players=this.Manager.createQuery(jpql,Player.class).setParameter("playerStatus",PlayerStatus.Unsold).getResultList();
		return players;
		 }catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception ();
		}
	}

	@Override
	public Users getAdminProfile(int userId) throws Exception {
		try {
		String jpql ="select u from Users u where u.userId=:userId";
		Users u=this.Manager.createNamedQuery(jpql, Users.class).setParameter("userId", userId).getSingleResult();
		return u;
		}
		catch(Exception e )
		{
			throw new Exception();
		}
	}
	
	@Override
	public void allowPlayerForLeague(int playerId) throws Exception {
		try {
			Player p=this.Manager.find(Player.class, playerId);
			p.setPlayerAllowedFlag(AllowedFlag.Allowed);
			this.Manager.merge(p);
			
		}
		catch(Exception e )
		{
			throw new Exception();
		}
	}
	@Override
	public void notallowPlayerForLeague(int playerId) throws Exception {
		try {
			Player p=this.Manager.find(Player.class, playerId);
			p.setPlayerAllowedFlag(AllowedFlag.NotAllowed);
			this.Manager.merge(p);
		}
		catch(Exception e )
		{
			throw new Exception();
		}
	}

	@Override
	public List<Player> getPlayerList(int teamId) throws Exception {
		try {

			System.out.println("teamid "+teamId);
			List<Player> p=new ArrayList<>();
			String jpql= "select p from Player p";
			List<Player>players =this.Manager.createQuery(jpql,Player.class).getResultList();
			System.out.println("players size :"+players.size());
			for (Player player : players) {
				if(player.getUser().getTeam()!=null) {
				if(player.getUser().getTeam().getTeamId()==teamId)
				{
					p.add(player);

				}
				}
			}
			//System.out.println(player.getUser().getTeam().getName());
			return p;
			}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@Override
	public void allowTeam(int teamId) throws Exception {
		
		try {
			Team t= this.Manager.find(Team.class,teamId);
			t.setTeamAllowedFlag(AllowedFlag.Allowed);
			this.Manager.merge(t);
		}
		catch(Exception e )
		{
			throw new Exception();
		}
	}

	
	
}
