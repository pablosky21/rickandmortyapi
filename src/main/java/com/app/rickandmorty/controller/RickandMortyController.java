package com.app.rickandmorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.rickandmorty.dto.RickandMortyResponse;
import com.app.rickandmorty.facade.RickandMortyFacade;


/**
 * The Class RickandMortyController.
 */
@RestController
public class RickandMortyController {

	/** The rickand morty facade. */
	@Autowired
	private RickandMortyFacade rickandMortyFacade;

	/**
	 * Gets the character by id.
	 *
	 * @param characterId the character id
	 * @return the character by id
	 */
	@GetMapping(value = "/getCharacterById/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RickandMortyResponse getCharacterById(@PathVariable String characterId) {

		return rickandMortyFacade.getCharacterById(characterId);
	}

}
