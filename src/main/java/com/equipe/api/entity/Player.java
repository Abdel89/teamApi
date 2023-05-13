package com.equipe.api.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name="PLAYER")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    // define table columns  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String surName;
    
    private int Age;
    
    private int Budget  ;
    
    private String position;
    
    private Date startConract;
    
    private Date endConract;
    
    // add foreign-key-constraint
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;

	public void setTeam(Team team) {
		this.team = team;
	}
    
}

	