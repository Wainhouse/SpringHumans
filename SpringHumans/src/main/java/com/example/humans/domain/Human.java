package com.example.humans.domain;

public class Human {

	
	// Attributes 
	
	private String name;
	private int ageOfBirth;
	private String planetofOrigin; 
	private boolean bionicTech; // do you have bionic tech
	private double updateVersion; // what update version are you?
	private String implantability; 
	
	// Constructor
	
	public Human(String name, int ageOfBirth, String planetofOrigin, boolean bionicTech, double updateVersion,
			String implantability) {
		super();
		this.name = name;
		this.ageOfBirth = ageOfBirth;
		this.planetofOrigin = planetofOrigin;
		this.bionicTech = bionicTech;
		this.updateVersion = updateVersion;
		this.implantability = implantability;
	}

	
	// Getters and Setters

	public Human() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAgeOfBirth() {
		return ageOfBirth;
	}


	public void setAgeOfBirth(int ageOfBirth) {
		this.ageOfBirth = ageOfBirth;
	}


	public String getPlanetofOrigin() {
		return planetofOrigin;
	}


	public void setPlanetofOrigin(String planetofOrigin) {
		this.planetofOrigin = planetofOrigin;
	}


	public boolean isBionicTech() {
		return bionicTech;
	}


	public void setBionicTech(boolean bionicTech) {
		this.bionicTech = bionicTech;
	}


	public double getUpdateVersion() {
		return updateVersion;
	}


	public void setUpdateVersion(double updateVersion) {
		this.updateVersion = updateVersion;
	}


	public String getImplantability() {
		return implantability;
	}


	public void setImplantability(String implantability) {
		this.implantability = implantability;
	}

	// To String
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", ageOfBirth=" + ageOfBirth + ", planetofOrigin=" + planetofOrigin
				+ ", bionicTech=" + bionicTech + ", updateVersion=" + updateVersion + ", implantability="
				+ implantability + "]";
	}
	
	
	
	
	
	
}

