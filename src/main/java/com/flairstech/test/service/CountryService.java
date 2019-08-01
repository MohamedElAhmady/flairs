package com.flairstech.test.service;

import com.flairstech.test.dto.CountryDto;


public interface CountryService {

	CountryDto getCountryByCode(String code);

}
