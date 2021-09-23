package com.app.rickandmorty.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.rickandmorty.domain.CharacterDomain;
import com.app.rickandmorty.domain.LocationDomain;
import com.app.rickandmorty.dto.RickandMortyResponse;
import com.app.rickandmorty.facade.RickandMortyFacade;
import com.app.rickandmorty.mapper.RickandMortyMapper;
import com.app.rickandmorty.service.CharacterService;
import com.app.rickandmorty.service.LocationService;

/**
 * The Class RickandMortyFacadeImpl.
 */
@Component
public class RickandMortyFacadeImpl implements RickandMortyFacade {

	/** The character service. */
	@Autowired
	private CharacterService characterService;

	/** The location service. */
	@Autowired
	private LocationService locationService;

	/** The rickand morty mapper. */
	@Autowired
	RickandMortyMapper rickandMortyMapper;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger("RickandMortyFacade");

	/**
	 * Gets the character by id.
	 *
	 * @param characterId the character id
	 * @return the character by id
	 */
	@Override
	public RickandMortyResponse getCharacterById(String characterId) {

		RickandMortyResponse response = new RickandMortyResponse();
		CharacterDomain characterResponse = new CharacterDomain();
		LocationDomain locationResponse = new LocationDomain();
		try {
			locationResponse = locationService.getCharacterLocationById(characterId);
			characterResponse = characterService.getCharacterById(characterId);
			response = rickandMortyMapper.characterDomainToDto(characterResponse, locationResponse,
					(characterResponse.getEpisode() != null && characterResponse.getEpisode().size() > 0)
							? characterResponse.getEpisode().size()
							: 0);
		} catch (Exception e) {
			logger.error("RickandMortyFacade Error-----", e);
		}
		return response;
	}

}
