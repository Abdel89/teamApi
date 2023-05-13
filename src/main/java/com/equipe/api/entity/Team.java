package com.equipe.api.entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Entity
@Table(name = "TEAM")
@Data
@NoArgsConstructor
public class Team {

	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50)
	private String name;
	@Column(length = 50)
	private String type;
	@Column(length = 50)
	private String division;
	@Column(length = 50)
	private Date creation;
	@Column(length = 50)
	private int budget;


	// add foreign-key-constraint
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> player;

	
	public boolean HasAllatributs() {
		return Stream.of(name, division, creation, budget).allMatch(Objects::nonNull);
	}

	public List<Player> getPlayer() {
		return player;
	}

	public Team(String name, String type, String division, Date creation, int budget) {
		super();
		this.name = name;
		this.type = type;
		this.division = division;
		this.creation = creation;
		this.budget = budget;
	};


}