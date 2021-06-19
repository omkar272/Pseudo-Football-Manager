package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*@JsonTypeInfo(use =JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Player.class, name = "Client")
})*/
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.JOINED) //used for creation of inherited class table in database 

@Entity
@Table(name = "user_tbl")
public class Users {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "firstname", length = 50)
	private String firstname;
	@Column(name = "lastname", length = 50)
	private String lastname;
	@Column(length = 50)
	private String phone;
	@Column(name = "age")
	private int age;
	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column(name = "email",unique=true, length = 50)
	private String email;
	@Column(name = "password", length = 200)
	private String password;
	@Column(name = "city", length = 50)
	private String city;
	@Column(name = "country", length = 50)
	private String country;
	@Transient
	private String Token;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 20)
	private Role userRole;

	//invesre side
	//@OneToOne(mappedBy = "user")
	//private Player player;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="team_id")
	private Team team;
	
	
	public Users()
	{
		System.out.println("User Object Gets Created->User()");
	} 
	
	public Users(String firstname,String lastname, int age, LocalDate DOB, String email, String password, String city, String country,
			Role userRole) 
	{
		System.out.println("User Object Created ->User(parameterised)");
		this.firstname= firstname;
		this.lastname=lastname;
		this.age = age;
		this.dob = DOB;
		this.email = email;
		this.password = password;
		this.city = city;
		this.country = country;
		this.userRole = userRole;
	}

	
		public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
		//team.setTeamId(0);
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {

		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	//public Player getPlayer() {
	//	return player;
	//}

	//public void setPlayer(Player player) {
		//this.player = player;
	//}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", age=" + age + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", city=" + city + ", country=" + country + ", userRole=" + userRole + "]";
	}
	
	

}
