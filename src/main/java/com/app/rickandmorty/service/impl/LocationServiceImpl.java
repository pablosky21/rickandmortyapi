package com.app.rickandmorty.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.rickandmorty.constant.Constants;
import com.app.rickandmorty.domain.LocationDomain;
import com.app.rickandmorty.service.LocationService;


/**
 * The Class LocationServiceImpl.
 */
@Service
public class LocationServiceImpl implements LocationService {

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/** The api url location. */
	@Value("${api.url.location}")
	private String API_URL_LOCATION;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger("CharacterService");

	/**
	 * Gets the character location by id.
	 *
	 * @param characterId the character id
	 * @return the character location by id
	 */
	@Override
	public LocationDomain getCharacterLocationById(String characterId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.PREFIX, characterId);
		LocationDomain locationReponse = new LocationDomain();

		try {
			locationReponse = restTemplate.getForObject(API_URL_LOCATION, LocationDomain.class, params);

		} catch (Exception e) {
			logger.error("CharacterService Error-----", e);
		}
		return locationReponse;
	}

}
