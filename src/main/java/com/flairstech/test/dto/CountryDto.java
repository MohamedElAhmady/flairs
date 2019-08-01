package com.flairstech.test.dto;

public class CountryDto {

	private String name;
	private String continent;
	private long population;
	private float lifeExpectancy;
	private String countryLanguage;

	public CountryDto(String name, String continent, long population, float lifeExpectancy, String countryLanguage) {
		super();
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.countryLanguage = countryLanguage;
	}

	public String getName() {
		return name;
	}

	public long getPopulation() {
		return population;
	}

	public float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public String getCountryLanguage() {
		return countryLanguage;
	}

	public String getContinent() {
		return continent;
	}

}
