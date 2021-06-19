package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Ground;
import com.app.pojos.Match;
import com.app.pojos.Player;
import com.app.pojos.Team;
import com.app.pojos.Users;
import com.app.service.IAdminService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	public AdminController() 
		{
			System.out.println("AdminController()  Object Created ");
		}
	
	@GetMapping("/get-team")
	public ResponseEntity<List<Team>> getTeams()
	{
		try {
			List<Team>teams=adminService.getTeams();

			return ResponseEntity.ok(teams);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

		}
	}
	
	@GetMapping("/get-grounds")
	public ResponseEntity<List<Ground>> getGrounds()
	{
		try {
			List<Ground>grounds= adminService.getGrounds();
			return ResponseEntity.ok(grounds);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

		}
	}
	
	@PostMapping("/shedule-match")
	public ResponseEntity<?>scheduleMatch(@RequestBody Match m){
		try {
			//adminService.
			adminService.sheduleMatch(m);
			return ResponseEntity.ok(HttpStatus.OK);
		}
		catch(Exception e)
		{
			 return new ResponseEntity<>("Match Sheduling Process Failed Something Went wrong",HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/show-scheduledmatches")
	public ResponseEntity<List<Match>> getFeaturedMatches(){
		
		try {
			 List<Match>matches =this.adminService.getScheduledMatches();
			 return ResponseEntity.ok(matches);
			}
		catch (Exception e )
		{
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/delete-scheduledmatch/{matchId}")
	public ResponseEntity<?>removeMatch(@PathVariable int matchId)
	{
			try {
			//System.out.println("deleted matchid "+matchId);
			this.adminService.deleteScheduledMatch(matchId);
			 return ResponseEntity.ok(HttpStatus.OK);
		}
		catch (Exception e )
		{
			return new ResponseEntity<>("Something Went Wrong...!!!",HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/start-scheduledmatch/{matchId}")
	public ResponseEntity<?>startMatch(@PathVariable int matchId)
	{
			try {
			//System.out.println("deleted matchid "+matchId);
			this.adminService.startScheduledMatch(matchId);
			 return ResponseEntity.ok(HttpStatus.OK);
		}
		catch (Exception e )
		{
			return new ResponseEntity<>("Something Went Wrong...!!!",HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/get_edited_match/{matchId}")
	public ResponseEntity<?>getEditedMatch(@PathVariable int matchId)
	{
			try {
			Match  m=this.adminService.getEditedMatch(matchId);

			 return ResponseEntity.ok(m);
		}
		catch (Exception e )
		{
			return new ResponseEntity<>("Something Went Wrong...!!!",HttpStatus.NO_CONTENT);
		}

	}
	
	@PostMapping("/update-schedule")
	public ResponseEntity<?>updatescheduleOfMatch(@RequestBody Match m){
		try {
			//adminService.
			adminService.updateSheduleOfMatch(m);
			return ResponseEntity.ok(HttpStatus.OK);
		}
		catch(Exception e)
		{
			 return new ResponseEntity<>("Match Sheduling Process Failed Something Went wrong",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/show-livematches")
	public ResponseEntity<List<Match>> getLiveMatches(){
		
		try {
			
			//return null;
			 List<Match>matches =this.adminService.getLiveMatches();
			 return ResponseEntity.ok(matches);
		}
		catch (Exception e )
		{
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/get-finishedmatches")
	public ResponseEntity<List<Match>> getFinishedMatches(){
		
		try {	
			//return null;
			 List<Match>matches =this.adminService.getFinishedMatches();
			 return ResponseEntity.ok(matches);
		}
		catch (Exception e )
		{
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/get-teamlist")
	public ResponseEntity<List<Team>> getTeamList(){
		
		try {
			
			List<Team>teams= this.adminService.getTeamList();
			 return ResponseEntity.ok(teams);
		}
		catch (Exception e )
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/update-score/{matchId}/{teamNo}")
	public ResponseEntity<?>updateScoreOfMatch(@PathVariable int matchId, @PathVariable int teamNo)
	{
		try {
			this.adminService.updateScoreOfTeam(matchId, teamNo);
			return ResponseEntity.ok(HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/finish-match/{matchId}")
	public ResponseEntity<?>finishMatch(@PathVariable int matchId)
	{
		try {
			this.adminService.finishMatch(matchId);
			return ResponseEntity.ok(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/show-registered-player")
	public ResponseEntity<List<Player>> showRegisteredPlayer()
	{
		System.out.println("public ResponseEntity<List<Player>> showRegisteredPlayer()");
		try {
			List<Player>players=this.adminService.showRegisteredPlayer();
			return ResponseEntity.ok(players);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/show-admin-profile")
	public ResponseEntity<Users> getAdminProfile(int userId)
	{
		try {
			Users admin=this.adminService.getAdminProfile(userId);
			return ResponseEntity.ok(admin);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/allow-player/{playerId}")
	public ResponseEntity<?> allowPlayerForLeague(@PathVariable int playerId)
	{
		try {
			this.adminService.allowPlayerForLeague(playerId);
			return ResponseEntity.ok(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/notallow-player/{playerId}")
	public ResponseEntity<?> notallowPlayerForLeague(@PathVariable int playerId)
	{
		try {
			this.adminService.notallowPlayerForLeague(playerId);
			return ResponseEntity.ok(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/team-playerlist/{teamId}")
	public ResponseEntity<List<Player>>getPlayerList(@PathVariable int teamId)
	{
		try {
			
			List<Team>teams= new ArrayList<>();
			List<Player>players=this.adminService.getPlayerList(teamId);
			
			return ResponseEntity.ok(players);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/registered-team-list")
	public ResponseEntity<List<Team>> getRegisteredTeamList(){
		
		try {
			List<Team>teams= this.adminService.getRegisteredTeamList();
			 return ResponseEntity.ok(teams);
		}
		catch (Exception e )
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/allow-team/{teamId}")
public ResponseEntity<?> getAllowTeam(@PathVariable int teamId){
		try {
			 this.adminService.allowTeam(teamId);
			 return ResponseEntity.ok(HttpStatus.OK);
		}
		catch (Exception e )
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
