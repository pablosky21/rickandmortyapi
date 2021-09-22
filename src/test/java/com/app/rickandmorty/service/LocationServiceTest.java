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
import com.app.rickandmorty.domain.LocationDomain;
import com.app.rickandmorty.service.impl.LocationServiceImpl;

import uk.co.jemos.podam.api.PodamFactory;

@SpringBootTest
public class LocationServiceTest {

	@Mock
	RestTemplate restTemplate;

	private PodamFactory podamFactory = PodamWebSingleton.getPodamFactory();

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Test
	public void test_getCharacterLocationById() throws URISyntaxException {

		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.PREFIX, "1");
		LocationDomain locationDomain = podamFactory.manufacturePojo(LocationDomain.class);

		Mockito.when(restTemplate.getForObject(ArgumentMatchers.anyString(), ArgumentMatchers.eq(LocationDomain.class),
				ArgumentMatchers.anyMap())).thenReturn(locationDomain);

		LocationDomain rickandMortyResponse = locationServiceImpl.getCharacterLocationById("1");
		assertTrue(rickandMortyResponse != null);

	}
}
