package com.app.rickandmorty.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


/**
 * Instantiates a new character domain.
 */
@Data
public class CharacterDomain {

	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The status. */
	private String status;
	
	/** The species. */
	private String species;
	
	/** The type. */
	private String type;
	
	/** The gender. */
	private String gender;
	
	/** The origin. */
	private OriginCharacterDomain origin;
	
	/** The location. */
	private LocationCharacterDomain location;
	
	/** The image. */
	private String image;
	
	/** The episode. */
	private List<String> episode;
	
	/** The url. */
	private String url;
	
	/** The created. */
	private LocalDateTime created;

}
