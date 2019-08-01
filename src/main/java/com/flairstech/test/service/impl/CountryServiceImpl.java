package com.flairstech.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flairstech.test.dto.CountryDto;
import com.flairstech.test.entity.Country;
import com.flairstech.test.entity.CountryLanguage;
import com.flairstech.test.repository.CountryRepository;
import com.flairstech.test.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public CountryDto getCountryByCode(String code) {

		Country country = countryRepository.findByCode(code);
		if (country == null)
			return null;
		String countryLanguage = null;
		for (CountryLanguage lang : country.getCountryLanguages()) {
			// get the first official language.
			if (lang.getIsOfficial())
				countryLanguage = lang.getId().getLanguage();
		}

		return new CountryDto(country.getName(), country.getContinent(), country.getPopulation(),
				country.getLifeExpectancy(), countryLanguage);

	}

}
