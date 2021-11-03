package com.example.humans.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.humans.domain.Human;
import com.example.humans.service.HumanService;

@RestController
public class HumanController {

	private List<Human> humans = new ArrayList<>();
	private HumanService service;

	public HumanController() {
		super();
		this.service = service;
	}

	@GetMapping("/hello-Human") // listening-for-a-get-request
	public String helloHuman() { // a human object in the request body
		return "Hello Human";
	}

	// CREATE
	@PostMapping("/create-Human") // trigger a post request
	// public Human createHuman(@RequestBody Human newHuman) { // a human object in
	// the request body
	public ResponseEntity<Human> createHuman(@RequestBody Human newHuman) {
		// this.humans.add(newHuman);
		// System.out.println(newHuman);
		// return this.humans.get(this.humans.size() -1);
		Human responseBody = this.service.createHuman(newHuman);
		return new ResponseEntity<Human>(responseBody, HttpStatus.CREATED);

	}

	// RETURN
	@GetMapping("/getAll") // we are returning the list to the console
	public ResponseEntity<List<Human>> getHumans() {
		return ResponseEntity.ok(this.service.getHumans());
	}

	// RETURN
	@GetMapping("/get/{id}") // getpuppy with id of {id}
	public Human getHuman(@PathVariable Integer id) {
		return this.service.getHuman(id);
	}

	// UPDATE
	@PutMapping("/replace/{id}")
	public ResponseEntity<Human> replaceHuman(@PathVariable Integer id, @RequestBody Human newHuman) {
		// this.humans.set(id, newHuman);

		System.out.println("Replacing human with id " + id + " with " + newHuman);
		Human body = this.service.replaceHuman(id, newHuman);

		return new ResponseEntity<Human>(body, HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeHuman(@PathVariable Integer id) {
		System.out.println("Removing Human with id " + id);
		boolean removed = this.service.removeHuman(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
