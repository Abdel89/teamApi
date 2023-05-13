package com.equipe.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.equipe.api.entity.Team;
import com.equipe.api.repository.teamRep;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EquipeApplicationTests {
	 	
	@Autowired
	private teamRep teamRep;

	
	Team teamTest = new Team( "FCB", "first","junior", new Date(25, 05, 2023), 77847);
	
	
	@Test
	public void should_store_a_team() {

		Team teamSave= teamRep.save(teamTest);
		

		assertThat(teamSave).hasFieldOrPropertyWithValue("name", "FCB");
		assertThat(teamSave).hasFieldOrPropertyWithValue("type", "first");
		assertThat(teamSave).hasFieldOrPropertyWithValue("division", "junior");
		assertThat(teamSave).hasFieldOrPropertyWithValue("budget", 77847);
		//effacer la team de test
		teamRep.delete(teamTest);
	}
}
