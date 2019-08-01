package com.flairstech.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flairstech.test.dto.CountryDto;
import com.flairstech.test.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries/{code}")
	public ResponseEntity<Object> getCountry(@PathVariable("code") String code) {
		try {

			CountryDto response = countryService.getCountryByCode(code);

			// If the code is invalid
			if (response == null)
				return new ResponseEntity<Object>("INVALID_COUNTRY_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Object>(response, HttpStatus.OK);

			// in case of database failure
		} catch (DataAccessResourceFailureException e) {
			return new ResponseEntity<Object>("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
