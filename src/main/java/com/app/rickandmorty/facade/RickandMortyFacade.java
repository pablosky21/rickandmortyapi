package com.app.rickandmorty.facade;

import com.app.rickandmorty.dto.RickandMortyResponse;


/**
 * The Interface RickandMortyFacade.
 */
public interface RickandMortyFacade {

	/**
	 * Gets the character by id.
	 *
	 * @param characterId the character id
	 * @return the character by id
	 */
	RickandMortyResponse getCharacterById(String characterId);

}
