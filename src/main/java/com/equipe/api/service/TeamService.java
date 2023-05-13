package com.equipe.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.equipe.api.entity.Player;
import com.equipe.api.entity.Team;

@Service
public interface TeamService {

	// get the list without order
	public List<Team> getAllTeams();
	// get all the teams order alphabetically
	public List<Team> getAllTeamsByAcronym();
    // get all the teams order by budget   
	public List<Team> getAllTeamsByBudget();
	// add Team 
	public Team addTeam(Team team); 

}