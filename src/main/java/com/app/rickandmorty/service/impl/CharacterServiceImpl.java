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
import com.app.rickandmorty.domain.CharacterDomain;
import com.app.rickandmorty.service.CharacterService;


/**
 * The Class CharacterServiceImpl.
 */
@Service
public class CharacterServiceImpl implements CharacterService {

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/** The api url character. */
	@Value("${api.url.character}")
	private String API_URL_CHARACTER;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger("CharacterService");

	/**
	 * Gets the character by id.
	 *
	 * @param characterId the character id
	 * @return the character by id
	 */
	@Override
	public CharacterDomain getCharacterById(String characterId) {
		

		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.PREFIX,characterId);
		CharacterDomain characterReponse = new CharacterDomain();

		try {
			characterReponse = restTemplate.getForObject(API_URL_CHARACTER, CharacterDomain.class, params);

		} catch (Exception e) {
			logger.error("CharacterService Error-----", e);
		}
		return characterReponse;

	}

}
