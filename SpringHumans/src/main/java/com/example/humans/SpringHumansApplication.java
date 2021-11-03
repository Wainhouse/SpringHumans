package com.example.humans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.humans.domain.Human;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringHumansApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringHumansApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();

		Human demoHuman = new Human("Luke", 2785, "Mars", true, 1.5, "Digital Mind");

		String demoHumanAsJSON = mapper.writeValueAsString(demoHuman);

		System.out.println(demoHumanAsJSON);

	}

}
