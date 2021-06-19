package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name="player_tbl")
//@DiscriminatorValue(value = "player") 
//@PrimaryKeyJoinColumn(name = "user_id") //it will take super class id as a primary as well as foreign key
public class Player{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "player_id")
	 private Integer playerId;
	 private double height;
	 private double weight;
	 @Column(name="games_played")
	 private int gamesPlayed=0;
	 private int goals=0;
	 private int assist=0;
	 private double price=0;
	 @Enumerated(EnumType.STRING)
	 @Column(name="player_position",length = 20)
	 private PlayerPosition position;
	 @Enumerated(EnumType.STRING)
	 @Column(name="player_flag",length = 20)
	 private PlayerFlag flag= PlayerFlag.Out;
	 @Enumerated(EnumType.STRING)
	 @Column(name="player_status",length = 20)
	 private PlayerStatus playerStatus=PlayerStatus.Unsold;
	 @Enumerated(EnumType.STRING)
	 @Column(name="player_allowing_flag",length = 20)
	 private AllowedFlag playerAllowedFlag=AllowedFlag.NotAllowed;
	 
	  //owning side
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="user_id", nullable = false)
	 private Users user;
	
	 public Player(){
		 super();
		 System.out.println("Player object gets Created");
		
	 }

	public Player(double height, double weight, int gamesPlayed, int goals, int assist, double price, PlayerPosition position,
			PlayerFlag flag, PlayerStatus playerStatus) {
		this.height = height;
		this.weight = weight;
		this.gamesPlayed = gamesPlayed;
		this.goals = goals;
		this.assist = assist;
		this.price = price;
		this.position = position;
		this.flag = flag;
		this.playerStatus = playerStatus;
	}
	
	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PlayerPosition getPosition() {
		return position;
	}
	
	public void setPosition(PlayerPosition position) {
		this.position = position;
	}

	public PlayerFlag getFlag() {
		return flag;
	}

	public void setFlag(PlayerFlag flag) {
		this.flag = flag;
	}

	public PlayerStatus getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(PlayerStatus playerStatus) {
		this.playerStatus = playerStatus;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public AllowedFlag getPlayerAllowedFlag() {
		return playerAllowedFlag;
	}

	public void setPlayerAllowedFlag(AllowedFlag playerAllowedFlag) {
		this.playerAllowedFlag = playerAllowedFlag;
	}

	//public Team getTeam() {
		//return team;
	//}

	//public void setTeam(Team team) {
		//this.team = team;
	//}

	@Override
	public String toString() {
		return "Player [height=" + height + ", weight=" + weight + ", gamesPlayed=" + gamesPlayed + ", goals=" + goals
				+ ", assist=" + assist + ", price=" + price + ", position=" + position + ", flag=" + flag
				+ ", playerStatus=" + playerStatus + "]";
	}




	 
}
