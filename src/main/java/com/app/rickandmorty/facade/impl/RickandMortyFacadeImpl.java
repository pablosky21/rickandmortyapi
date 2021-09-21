package com.app.rickandmorty.facade.impl;

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
		locationResponse = locationService.getCharacterLocationById(characterId);
		characterResponse = characterService.getCharacterById(characterId);
		response = rickandMortyMapper.characterDomainToDto(characterResponse, locationResponse,
				(characterResponse.getEpisode() != null && characterResponse.getEpisode().size() > 0)
						? characterResponse.getEpisode().size()
						: 0);

		return response;
	}

}
