package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IHomeDao;
import com.app.pojos.Match;
import com.app.pojos.Team;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {
	@Autowired
	IHomeDao homeDao;
	
	@GetMapping("/get-teams")
	public ResponseEntity<List<Team>> getTeams()
	{
		System.out.println("Call Raised");
		try {
			List<Team>teams=homeDao.getTeams();
			System.out.println(teams.size());
			return ResponseEntity.ok(teams);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

		}
	}
	
	@GetMapping("/get-liveMatches")
	public ResponseEntity<List<Match>> getLiveMatches()
	{
		//System.out.println("Call Raised");
		try {
			List<Match>matches=homeDao.getLiveMatches();
			//System.out.println(teams.size());
			return ResponseEntity.ok(matches);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

		}
	}
	
	
	@GetMapping("/get-featuredMatches")
	public ResponseEntity<List<Match>> getFeaturedMatches()
	{
		System.out.println("Call Raised");
		try {
			List<Match>matches=homeDao.getFeaturedMatches();
			return ResponseEntity.ok(matches);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

		}
	}
	
}
