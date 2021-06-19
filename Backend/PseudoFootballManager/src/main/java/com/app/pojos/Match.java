package com.app.pojos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="match_tbl")
public class Match
{
	//id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="match_id")
    private Integer matchId;
	//status
	@Column(name = "match_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate  matchDate;
	@Column(name="match_start_time")
	private LocalTime matchStartTime;
	@Column(name="match_end_time")
	private LocalTime matchEndTime;
	@Column(name="first_team_score", nullable = false)
	private int firstTeamScore=0;
	@Column(name="second_team_score", nullable = false)
	private int secondTeamScore=0;
	@Enumerated(EnumType.STRING)
	@Column(name = "match_status", length = 50)
    private MatchStatus matchStatus=MatchStatus.Featured;
	@OneToOne
	@JoinColumn(name="first_team_id")
	private Team firstTeam;
	@OneToOne
	@JoinColumn(name="second_team_id")
	private Team secondTeam;
	 //inverse
	 @ManyToOne
	 @JoinColumn(name = "ground_id",nullable = false)
	 private Ground ground;

	
	    
	 
	public Match() {
		System.out.println("Match Object Gets Created");
	}

	public Match(Integer matchId, LocalDate matchDate, LocalTime matchStartTime, LocalTime matchEndTime,
			MatchStatus matchStatus, Team firstTeam, Team secondTeam, Ground ground) {
		super();
		this.matchId = matchId;
		this.matchDate = matchDate;
		this.matchStartTime = matchStartTime;
		this.matchEndTime = matchEndTime;
		this.matchStatus = matchStatus;
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.ground = ground;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public LocalTime getMatchStartTime() {
		return matchStartTime;
	}

	public void setMatchStartTime(LocalTime matchStartTime) {
		this.matchStartTime = matchStartTime;
	}

	public LocalTime getMatchEndTime() {
		return matchEndTime;
	}

	public void setMatchEndTime(LocalTime matchEndTime) {
		this.matchEndTime = matchEndTime;
	}

	public MatchStatus getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(Team firstTeam) {
		this.firstTeam = firstTeam;
	}

	public Team getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(Team secondTeam) {
		this.secondTeam = secondTeam;
	}

	public Ground getGround() {
		return ground;
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	public int getFirstTeamScore() {
		return firstTeamScore;
	}

	public void setFirstTeamScore(int firstTeamScore) {
		this.firstTeamScore = firstTeamScore;
	}

	public int getSecondTeamScore() {
		return secondTeamScore;
	}

	public void setSecondTeamScore(int secondTeamScore) {
		this.secondTeamScore = secondTeamScore;
	}

	

    
    

}