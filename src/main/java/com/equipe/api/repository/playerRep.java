package com.equipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equipe.api.entity.Player;



@Repository
public interface playerRep extends JpaRepository<Player, Long> {
}