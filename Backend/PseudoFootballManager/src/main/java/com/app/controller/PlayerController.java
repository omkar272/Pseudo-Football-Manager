package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IPlayerDao;
import com.app.pojos.Match;
import com.app.pojos.Player;
import com.app.pojos.Users;

@RestController
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {

	
	@Autowired
	private IPlayerDao playerDao;
	
	
	@GetMapping("/get-profile/{userId}")
	public ResponseEntity<?> getProfile(@PathVariable int userId){
			
		try {
			System.out.println("call raised "+userId);
			
			 Player p=this.playerDao.getProfile(userId);
			 System.out.println(p.getUser().getFirstname());
			 return ResponseEntity.ok(p);
		}
		catch (Exception e )
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	///get-Matches
}
