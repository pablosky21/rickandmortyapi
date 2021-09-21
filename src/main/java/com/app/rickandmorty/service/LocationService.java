package com.app.rickandmorty.service;

import com.app.rickandmorty.domain.LocationDomain;


/**
 * The Interface LocationService.
 */
public interface LocationService {

	/**
	 * Gets the character location by id.
	 *
	 * @param characterId the character id
	 * @return the character location by id
	 */
	LocationDomain getCharacterLocationById(String characterId);

}
