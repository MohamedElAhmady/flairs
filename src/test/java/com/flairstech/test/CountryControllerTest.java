package com.flairstech.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.flairstech.test.dto.CountryDto;
import com.flairstech.test.service.impl.CountryServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CountryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryServiceImpl countryService;

    @Test
    public void testGetCountryByCode() throws Exception {
      CountryDto result = new CountryDto("Egypt", "Africa", 68470000, 63.3f, "Arabic");

        given(countryService.getCountryByCode("EGY")).willReturn(result);

        // when + then
        this.mockMvc.perform(get("/api/countries/EGY"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'name': 'Egypt','continent': 'Africa', 'population':68470000, 'lifeExpectancy':63.3, 'countryLanguage' : 'Arabic' }"));
    }
    
    
    @Test
    public void testInvalidCountryCode() throws Exception {
        given(countryService.getCountryByCode("XXX")).willReturn(null);

        // when + then
        this.mockMvc.perform(get("/api/countries/XXX"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("INVALID_COUNTRY_CODE"));
    }
}