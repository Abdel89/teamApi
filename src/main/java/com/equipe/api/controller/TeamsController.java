package com.equipe.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equipe.api.EquipeApplication;
import com.equipe.api.entity.Team;
import com.equipe.api.service.TeamService;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/teamApi")
@AllArgsConstructor
@Slf4j
public class TeamsController {
	@Autowired
	private TeamService teamService;

	private static final Logger logger = LoggerFactory.getLogger(TeamsController.class);

	// retourner toutes les equipes sans ordre
	@RequestMapping(value = "/getAllTeamWithoutOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getAllTeamNoOrder() {
		try {
			logger.debug("get all teams without tri");
			return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
		} catch (Exception e) {
			logger.debug("erro calling all tams {},e");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	// retourner toutes les equipes en ordre alphabetic
	@RequestMapping(value = "/getAllTeamAlphaOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getAllTeamAlphaOrder() {
		try {
			logger.debug("get all teams ByAcronym");
			return new ResponseEntity<>(teamService.getAllTeamsByAcronym(), HttpStatus.OK);
		} catch (Exception e) {
			logger.debug("erro calling all tams {},e");
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// retourner toutes les equipes en order du budget
	@RequestMapping(value = "/getAllTeamBudjetOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getAllTeamBudgOrder() {
		try {
			return new ResponseEntity<>(teamService.getAllTeamsByBudget(), HttpStatus.OK);
		} catch (Exception e) {
			logger.debug("erro calling all tams {},e");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	// Enregistrer une nouvelle equipe avec ou sans joeurs
	@RequestMapping(value = "/addTeam", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> AddTeam(@RequestBody(required = true) Team team) {
		try {
			// verifier si team a tout les attribus
			if (team.HasAllatributs()) {

				return new ResponseEntity<>(teamService.addTeam(team), HttpStatus.OK);
			} else {
				logger.debug("eargs is missing cannot procced");
				return new ResponseEntity<>(null, HttpStatus.FAILED_DEPENDENCY);
			}

		} catch (Exception e) {
			// logger.debug("erro calling all tams {},e");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}