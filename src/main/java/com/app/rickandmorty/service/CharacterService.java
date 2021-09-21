package com.app.rickandmorty.service;

import com.app.rickandmorty.domain.CharacterDomain;


/**
 * The Interface CharacterService.
 */
public interface CharacterService {

	/**
	 * Gets the character by id.
	 *
	 * @param characterId the character id
	 * @return the character by id
	 */
	CharacterDomain getCharacterById(String characterId);

}
