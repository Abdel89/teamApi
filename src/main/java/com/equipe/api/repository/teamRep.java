package com.equipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.equipe.api.entity.Team;



@Repository
public interface teamRep extends JpaRepository<Team, Long> {
	  // @Query("select e from Employee e where e.firstName = :firstName")
	  //  List<Team> findTeams();
	   
	 
}