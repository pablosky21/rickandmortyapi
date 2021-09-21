package com.app.rickandmorty.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.rickandmorty.domain.CharacterDomain;
import com.app.rickandmorty.domain.LocationDomain;
import com.app.rickandmorty.dto.RickandMortyResponse;


/**
 * The Interface RickandMortyMapper.
 */
@Mapper(componentModel = "spring")
public interface RickandMortyMapper {

	/**
	 * Character domain to dto.
	 *
	 * @param character the character
	 * @param locationDomain the location domain
	 * @param episode_count the episode count
	 * @return the rickand morty response
	 */
	@Mapping(source = "character.id", target = "id")	
	@Mapping(source = "character.name", target = "name")	
	@Mapping(source = "character.type", target = "type")	
	@Mapping(source = "locationDomain.residents", target = "origin.residents")	
	@Mapping(source = "locationDomain.name", target = "origin.name")	
	@Mapping(source = "locationDomain.url", target = "origin.url")	
	@Mapping(source = "locationDomain.dimension", target = "origin.dimension")	
	@Mapping(source = "episode_count", target = "episode_count")	
	RickandMortyResponse characterDomainToDto(CharacterDomain character, LocationDomain locationDomain, int episode_count );
	
	

}
