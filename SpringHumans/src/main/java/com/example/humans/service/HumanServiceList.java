package com.example.humans.service;

import java.util.ArrayList;
import java.util.List;

import com.example.humans.domain.Human;

public class HumanServiceList implements HumanService { 
	
	
	private List<Human> humansList = new ArrayList<>();

	@Override
	public Human createHuman(Human newHuman) { // a puppy object in the request + response
		this.humansList.add(newHuman);
		
		return this.humansList.get(this.humansList.size() -1);
	}

	@Override
	public Human getHuman(Integer id) {
		// TODO Auto-generated method stub
		return this.humansList.get(id);
	}
	
	@Override
	public List<Human> getHumans() {
		
		return this.humansList;
	}

	@Override
	public Human replaceHuman(Integer id, Human newHuman) {
	
		return this.humansList.set(id, newHuman); // replaces the puppy at that index
	}

	@Override
	public boolean removeHuman(Integer id) { 
		Human toRemove = this.humansList.get(id);
		this.humansList.remove(id.intValue());
		return !this.humansList.contains(toRemove);
	}
	
	
	
 
}
