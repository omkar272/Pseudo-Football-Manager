package com.app.dao;

import java.util.List;

import com.app.pojos.Match;
import com.app.pojos.Team;

public interface IHomeDao {

	
	public List<Team> getTeams() throws Exception;

	public List<Match> getLiveMatches() throws Exception;
	
	public List<Match> getFeaturedMatches() throws Exception;
}
