package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.pojos.AllowedFlag;
import com.app.pojos.Match;
import com.app.pojos.MatchStatus;
import com.app.pojos.Team;

@Repository
@Service
@Transactional
public class HomeDaoImpl implements IHomeDao {
	
	@Autowired
	private EntityManager Manager;

	
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
				throw new Exception();
				
			}
		
	}
	
	
	@Override
	public List<Match> getFeaturedMatches() throws Exception {
		try {
			
			String jpql= "select m from Match m where m.matchStatus=:matchStatus";
			List<Match>matches=Manager.createQuery(jpql,Match.class).setParameter("matchStatus",MatchStatus.Featured).getResultList();
			//System.out.println("dao matches "+matches);
			for (Match match : matches) {
				System.out.println("match"+match.getMatchId());
			}
			return matches;
			}
			
			catch(Exception e)
			{
				throw new Exception();
				
			}
		
	}

	
}
