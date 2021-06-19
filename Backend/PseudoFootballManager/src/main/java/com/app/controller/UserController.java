package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.helper.JwtResponse;
import com.app.helper.JwtUtil;
import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;
import com.app.service.ICustomUserService;
import com.app.service.IUserService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;
	@Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ICustomUserService customService;

	public UserController() {
		System.out.println("Object Of UserController Created");	
		}

	
	@PostMapping("/login")
	public ResponseEntity<?>authenticateUser(@RequestBody Users u){
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(u.getEmail(), u.getPassword()));
			UserDetails customUser= this.customService.loadUserByUsername(u.getEmail());
			String token= this.jwtUtil.generateToken(customUser);
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			Users user=this.userService.findByEmail(u.getEmail());
			user.setToken(token);
			return ResponseEntity.ok(user);
		}catch(Exception e){
			return new ResponseEntity<>("Invalid Credentials Please Try Again",HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/register")//admin
	public ResponseEntity<?> registerUser(@RequestBody Users u){
		//System.out.println("outside of try"+u.getPassword());
		try {
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		 userService.registerUser(u);
		 return new ResponseEntity<>("Admin Registration not allowed",HttpStatus.METHOD_NOT_ALLOWED);
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.OK);
			 
		}
	}
	
	@PostMapping("/registerManager")//admin, Manager,  Reporter,Coach
	public ResponseEntity<?> registerManager(@RequestBody Users u){
		System.out.println("outside of try"+u.getPassword());
		try {
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			//System.out.println(u.getPassword());
		 userService.registerManager(u);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			 return new ResponseEntity<>("Registration failed Record already Exist",HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/registerPlayer")//player 
	public ResponseEntity<?> registerPlayer(@RequestBody Player p){
		try {
			System.out.println(p);
			p.getUser().setPassword(bCryptPasswordEncoder.encode(p.getUser().getPassword()));
			System.out.println(p.getUser());
		 String massage=userService.registerPlayer(p);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/player-data/{userId}")
	
	public ResponseEntity<?> getPlayerInfo(@PathVariable int userId) {
		try {
			System.out.println("hi");
			Player p= this.userService.getPlayerInfo(userId);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/team-status/{teamId}")
	public ResponseEntity<Team> getTeamStatus(@PathVariable int teamId)
	{
		try {
			Team t= this.userService.getTeamStatus(teamId);
			return ResponseEntity.ok(t);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
}
