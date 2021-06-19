package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="team_tbl")
public class Team 
{
	@Id
	@Column(name="team_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;
	
	@Column(length = 50, unique = true)
	private String name;
  	@Column(name = "rank_of_team")
    private int rankOfTeam=0;
	
    @Column(name="no_of_match_played")
    private int noOfMatchPlayed=0;
    
    @Column(name="no_of_win")
    private int noOfWin=0;
    
    @Column(name="no_of_lose")
    private int noOfLose=0;
    
    @Column(name="no_of_draws")
    private int noOfDraws=0;
    
    @Column(name = "total_score")
	private int totalScore=0; //(0=loose, 1 =draw, 2=loose)
    
    @Column(name="no_of_goals")
    private int noOfGoals=0;
    
    @OneToOne
    @JoinColumn(name = "league_id")
    private League league;
    
    @Enumerated(EnumType.STRING)
    @Column(name="team_allowing_flag",length = 20)
	 private AllowedFlag teamAllowedFlag=AllowedFlag.NotAllowed;
    
    //owning
   // @OneToMany(mappedBy = "team",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    //private List<Player> players;
   
   public Team(){
    	System.out.println("Team Object Gets ");
    }
	
	public Team(Integer teamId, String name, int rankOfTeam, int noOfMatchPlayed, int noOfWin, int noOfLose, int noOfDraws,
		int totalScore, int noOfGoals, League league, AllowedFlag teamAllowedFlag) {
	super();
	this.teamId = teamId;
	this.name = name;
	this.rankOfTeam = rankOfTeam;
	this.noOfMatchPlayed = noOfMatchPlayed;
	this.noOfWin = noOfWin;
	this.noOfLose = noOfLose;
	this.noOfDraws = noOfDraws;
	this.totalScore = totalScore;
	this.noOfGoals = noOfGoals;
	this.league = league;
	this.teamAllowedFlag = teamAllowedFlag;
}

	public Integer getTeamId() {
	return teamId;
}

public void setTeamId(Integer teamId) {
	this.teamId = teamId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getRankOfTeam() {
	return rankOfTeam;
}

public void setRankOfTeam(int rankOfTeam) {
	this.rankOfTeam = rankOfTeam;
}

public int getNoOfMatchPlayed() {
	return noOfMatchPlayed;
}

public void setNoOfMatchPlayed(int noOfMatchPlayed) {
	this.noOfMatchPlayed = noOfMatchPlayed;
}

public int getNoOfWin() {
	return noOfWin;
}

public void setNoOfWin(int noOfWin) {
	this.noOfWin = noOfWin;
}

public int getNoOfLose() {
	return noOfLose;
}

public void setNoOfLose(int noOfLose) {
	this.noOfLose = noOfLose;
}

public int getNoOfDraws() {
	return noOfDraws;
}

public void setNoOfDraws(int noOfDraws) {
	this.noOfDraws = noOfDraws;
}

public int getTotalScore() {
	return totalScore;
}

public void setTotalScore(int totalScore) {
	this.totalScore = totalScore;
}

public int getNoOfGoals() {
	return noOfGoals;
}

public void setNoOfGoals(int noOfGoals) {
	this.noOfGoals = noOfGoals;
}

public League getLeague() {
	return league;
}

public void setLeague(League league) {
	this.league = league;
}

public AllowedFlag getTeamAllowedFlag() {
	return teamAllowedFlag;
}

public void setTeamAllowedFlag(AllowedFlag teamAllowedFlag) {
	this.teamAllowedFlag = teamAllowedFlag;
}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", rankOfTeam=" + rankOfTeam + ", noOfMatchPlayed="
				+ noOfMatchPlayed + ", noOfWin=" + noOfWin + ", noOfLose=" + noOfLose + ", noOfDraws=" + noOfDraws
				+ "]";
	}   
}
