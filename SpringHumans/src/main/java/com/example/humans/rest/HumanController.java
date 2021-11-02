package com.example.humans.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.humans.domain.Human;

@RestController
public class HumanController {

	private List<Human> humans = new ArrayList<>(); 
	
	@GetMapping("/hello-Human") // listening-for-a-get-request
	public String helloHuman() { // a human object in the request body 
		return"Hello Human";
	}
	
	@PostMapping("/create-Human")    //trigger a post request	
	public Human createHuman(@RequestBody Human newHuman) { // a human object in the request body
		this.humans.add(newHuman);
		System.out.println(newHuman);
		return this.humans.get(this.humans.size() -1);
		
	}
	
	@GetMapping("/getAll") // we are returning the list to the console
	public List<Human> getHumans() {
		return this.humans;
	}
	
	@GetMapping("/get/{id}")
	public Human getHuman(@PathVariable Integer id) {
		return this.humans.get(id);
	}
	
//	@DeleteMapping("/remove/{id}")
//	public void removeHuman
	
}
 