package com.flairstech.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flairstech.test.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

	Country findByCode(String code);

}
