package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Player;
import com.app.service.IManagerService;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	public IManagerService managerService;
	
	
	@GetMapping("/get-teamplayer/{userId}")
	public ResponseEntity<List<Player>>getPlayerInTeam(@PathVariable int userId)
	{
		try {
			List<Player>players=this.managerService.getTeamPlayer(userId);
//			for (Player player : players) {
//				if(player.getTeam().getPlayers()!=null)
//				player.getTeam().setPlayers(null);
//			}
			return ResponseEntity.ok(players);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/unsold-players")
	public ResponseEntity<List<Player>>getUnsoldPlayer()
	{
		try {
			List<Player>players=this.managerService.getUnsoldPlayer();
//			for (Player player : players) {
//				if(player.getTeam()!=null)
//				player.setTeam(null);
//				
//			}
			return ResponseEntity.ok(players);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/purchase-player/{userId}/{playerId}") //userid for team
	public ResponseEntity<?>purchasePlayer(@PathVariable  int userId, @PathVariable int playerId)
	{
		try {
			
			this.managerService.purchasePlayer(userId,playerId);
			return ResponseEntity.ok(HttpStatus.OK);
			

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	
	
	
	@GetMapping("/release-player/{playerId}") //userid for team
	public ResponseEntity<?>purchasePlayer(@PathVariable int playerId)
	{
		try {
			this.managerService.relasePlayer(playerId);
			return ResponseEntity.ok(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}













