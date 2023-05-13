package com.equipe.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.equipe.api.entity.Player;
import com.equipe.api.entity.Team;
import com.equipe.api.repository.teamRep;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamServiceImp implements TeamService{
	
	@Autowired 
	private  teamRep teamRepository ;

	@Override
	public List<Team> getAllTeams() {
		//retourner toutes les equipes sans tri
		return teamRepository.findAll();
	}

	@Override
	public List<Team> getAllTeamsByAcronym() {
		//retourner toutes les equipes avec tri par nom 
		return teamRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		
	}

	@Override
	public List<Team> getAllTeamsByBudget() {
		//retourner toutes les equipes avec tri budget 
		 return teamRepository.findAll(Sort.by(Sort.Direction.ASC, "budget"));
	}

	

	@Override
	public Team addTeam(Team team) {
		// add the new team 
		try{
			Team teamSave =teamRepository.save(team);
			teamSave.getPlayer().forEach(player-> player.setTeam(teamSave));
			//save FK keys
			Team teamSaveFk =teamRepository.save(team);
			return teamSaveFk;
		}
		catch(Exception e) {}
	    return null;
	}
	

   
}