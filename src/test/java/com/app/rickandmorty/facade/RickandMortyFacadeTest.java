package com.app.rickandmorty.facade;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.rickandmorty.common.PodamWebSingleton;
import com.app.rickandmorty.domain.CharacterDomain;
import com.app.rickandmorty.domain.LocationDomain;
import com.app.rickandmorty.dto.RickandMortyResponse;
import com.app.rickandmorty.facade.impl.RickandMortyFacadeImpl;
import com.app.rickandmorty.service.CharacterService;
import com.app.rickandmorty.service.LocationService;

import uk.co.jemos.podam.api.PodamFactory;

@SpringBootTest
public class RickandMortyFacadeTest {

	@Autowired
	private RickandMortyFacadeImpl rickandMortyFacadeImpl;

	@MockBean
	private CharacterService characterService;
	
	@MockBean
	private LocationService locationService;

	private PodamFactory podamFactory = PodamWebSingleton.getPodamFactory();
	
	
	@Test
	void testGetCharacterById() {
		CharacterDomain characterDomain = podamFactory.manufacturePojo(CharacterDomain.class);
		LocationDomain locationDomain = podamFactory.manufacturePojo(LocationDomain.class);
		

		when(characterService.getCharacterById("1")).thenReturn(characterDomain);
		when(locationService.getCharacterLocationById("1")).thenReturn(locationDomain);
		
		RickandMortyResponse rickandMortyResponse = rickandMortyFacadeImpl.getCharacterById("1");
		assertTrue(rickandMortyResponse != null);
	}
	
	@Test
	void testGetCharacter2ById() {
		CharacterDomain characterDomain = podamFactory.manufacturePojo(CharacterDomain.class);
		LocationDomain locationDomain = podamFactory.manufacturePojo(LocationDomain.class);
		characterDomain.getEpisode().clear();

		when(characterService.getCharacterById("1")).thenReturn(characterDomain);
		when(locationService.getCharacterLocationById("1")).thenReturn(locationDomain);
		
		RickandMortyResponse rickandMortyResponse = rickandMortyFacadeImpl.getCharacterById("1");
		assertTrue(rickandMortyResponse != null);
	}
}
