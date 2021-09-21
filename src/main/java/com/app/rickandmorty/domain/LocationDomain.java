package com.app.rickandmorty.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


/**
 * Instantiates a new location domain.
 */
@Data
public class LocationDomain {

	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The type. */
	private String type;
	
	/** The dimension. */
	private String dimension;
	
	/** The residents. */
	private List<String> residents;
	
	/** The url. */
	private String url;
	
	/** The created. */
	private LocalDateTime created;

}
