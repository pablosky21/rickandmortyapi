package com.app.rickandmorty.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.app.rickandmorty.dto.RickandMortyResponse;
import com.app.rickandmorty.facade.RickandMortyFacade;

@WebMvcTest
public class RickandMortyControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RickandMortyFacade rickandMortyFacade;

	@Test
	void testGetCharacterById() throws Exception {
		RickandMortyResponse rickandMortyResponse = new RickandMortyResponse();
		when(rickandMortyFacade.getCharacterById("1")).thenReturn(rickandMortyResponse);
		this.mvc.perform(get("/getCharacterById/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));

	}

}
