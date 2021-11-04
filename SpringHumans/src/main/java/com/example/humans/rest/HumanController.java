// The controller talks to the frontend;

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

@RestController // enables request handling

public class HumanController {

	private List<Human> humans = new ArrayList<>();

	// Creating private list because we're not implementing the database yet
	private HumanService service;

	public HumanController() {
		super();
		this.service = service;
	}

	// checking that spring is working
	@GetMapping("/hello-Human") // listening-for-a-get-request
	public String helloHuman() { // a human object in the request body
		return "Hello Human";
	}

	// CREATE
	@PostMapping("/create-Human") // trigger a post request
	public ResponseEntity<Human> createHuman(@RequestBody Human newHuman) {
		Human responseBody = this.service.createHuman(newHuman);
		return new ResponseEntity<Human>(responseBody, HttpStatus.CREATED);

	}

	// Reading
	// returning a list of everything in humans list to the console.
	@GetMapping("/getAll") // we are returning the list to the console
	public ResponseEntity<List<Human>> getHumans() {
		return ResponseEntity.ok(this.service.getHumans());
	}

	// RETURN
	@GetMapping("/get/{id}") // gethuman with id of {id}
	public Human getHuman(@PathVariable Integer id) { //// Getting human with id of {id} // Pathvariable gets the index
														//// position from the URL e.g localhost/8080/get/01
		return this.service.getHuman(id);
	}

	// UPDATE - Getting a specfic index in the list
	@PutMapping("/replace/{id}")
	public ResponseEntity<Human> replaceHuman(@PathVariable Integer id, @RequestBody Human newHuman) { // @RequestBody
																										// will create a
																										// new human
																										// object(internally
																										// an object
																										// mapper
																										// converts the
																										// jason code
																										// back to java)
		// this.humans.set(id, newHuman);

		System.out.println("Replacing human with id " + id + " with " + newHuman); // changing the references so that
																					// we're refereing to humanservices
																					// (aliased as service) and the
																					// methods in there
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
