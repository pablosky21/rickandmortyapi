package com.app.rickandmorty.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.app.rickandmorty.common.PodamWebSingleton;
import com.app.rickandmorty.constant.Constants;
import com.app.rickandmorty.domain.CharacterDomain;
import com.app.rickandmorty.service.impl.CharacterServiceImpl;

import uk.co.jemos.podam.api.PodamFactory;

@SpringBootTest
public class CharacterServiceTest {

	@Mock
	RestTemplate restTemplate;

	private PodamFactory podamFactory = PodamWebSingleton.getPodamFactory();

	@Autowired
	private CharacterServiceImpl characterServiceImpl;

	@Test
	public void test_getCharacterById() throws URISyntaxException {

		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.PREFIX, "1");
		CharacterDomain characterDomain = podamFactory.manufacturePojo(CharacterDomain.class);

		Mockito.when(restTemplate.getForObject(ArgumentMatchers.anyString(), ArgumentMatchers.eq(CharacterDomain.class),
				ArgumentMatchers.anyMap())).thenReturn(characterDomain);

		CharacterDomain rickandMortyResponse = characterServiceImpl.getCharacterById("1");
		assertTrue(rickandMortyResponse != null);

	}
}
