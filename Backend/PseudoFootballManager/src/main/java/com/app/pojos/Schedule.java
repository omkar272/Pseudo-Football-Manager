//package com.app.pojos;
//
//import java.sql.Time;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import javax.persistence.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name="schedule_tbl")
//public class Schedule
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="schedule_id")
//	private Integer scheduleId;
//	@Column(name = "match_date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate  matchDate;
//	@Column(name="match_start_time")
//	private LocalTime matchStartTime;
//	@Column(name="match_end_time")
//	private LocalTime matchEndTime;
//  //inverse
//	@OneToOne(mappedBy = "shedules")
//	private Match match;
//	
//	public Schedule() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Schedule(Integer scheduleId, LocalDate matchDate, LocalTime matchStartTime, LocalTime matchEndTime,
//			Match match) {
//		super();
//		this.scheduleId = scheduleId;
//		this.matchDate = matchDate;
//		this.matchStartTime = matchStartTime;
//		this.matchEndTime = matchEndTime;
//		this.match = match;
//	}
//
//	public Integer getScheduleId() {
//		return scheduleId;
//	}
//
//	public void setScheduleId(Integer scheduleId) {
//		this.scheduleId = scheduleId;
//	}
//
//	public LocalDate getMatchDate() {
//		return matchDate;
//	}
//
//	public void setMatchDate(LocalDate matchDate) {
//		this.matchDate = matchDate;
//	}
//
//	public LocalTime getMatchStartTime() {
//		return matchStartTime;
//	}
//
//	public void setMatchStartTime(LocalTime matchStartTime) {
//		this.matchStartTime = matchStartTime;
//	}
//
//	public LocalTime getMatchEndTime() {
//		return matchEndTime;
//	}
//
//	public void setMatchEndTime(LocalTime matchEndTime) {
//		this.matchEndTime = matchEndTime;
//	}
//
//	public Match getMatch() {
//		return match;
//	}
//
//	public void setMatch(Match match) {
//		this.match = match;
//	}
//
//	@Override
//	public String toString() {
//		return "Schedule [scheduleId=" + scheduleId + ", matchDate=" + matchDate + ", matchStartTime=" + matchStartTime
//				+ ", matchEndTime=" + matchEndTime + ", match=" + match + "]";
//	}
//
//	
//	
//}
