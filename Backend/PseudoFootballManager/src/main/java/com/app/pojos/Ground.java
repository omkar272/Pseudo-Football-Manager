package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ground_tbl")
public class Ground
{
	@Id
	@Column(name="ground_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groundId;
	@Column(name="ground_name", length = 50,unique = true)
    private String groundName;
	@Column(name="city", length = 50)
    private String city;
	@Column(name="country", length = 50)
    private String country;
	@Column(name="capacity", length = 50)
    private int capacity;
	
	
    public Ground() {
		System.out.println("public Ground()");
	}

	public Ground(int groundId, String groundName, String city, String country, int capacity) {
		super();
		this.groundId = groundId;
		this.groundName = groundName;
		this.city = city;
		this.country = country;
		this.capacity = capacity;
	}

	public int getGroundId() {
		return groundId;
	}

	public void setGroundId(int groundId) {
		this.groundId = groundId;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Ground [groundId=" + groundId + ", groundName=" + groundName + ", city=" + city + ", country=" + country
				+ ", capacity=" + capacity + "]";
	}

	
}
