package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="league_tbl")
public class League
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="league_id")
	private Integer leagueId;
	@Column(length = 50,unique=true)
	private String name;
	@Column(length = 50)
	private String country;
	
  
  public League() {
	System.out.println("public League()");
}

public League(int leagueId, String name, String country, List<Match> matches, List<Team> teams, List<Ground> grounds) {
	this.leagueId = leagueId;
	this.name = name;
	this.country = country;
}

public int getLeagueId() {
	return leagueId;
}

public void setLeagueId(int leagueId) {
	this.leagueId = leagueId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public void setLeagueId(Integer leagueId) {
	this.leagueId = leagueId;
}

	
  
}