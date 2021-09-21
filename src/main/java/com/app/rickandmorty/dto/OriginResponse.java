package com.app.rickandmorty.dto;

import java.util.List;

import lombok.Data;


/**
 * Instantiates a new origin response.
 */
@Data
public class OriginResponse {

	/** The name. */
	public String name;

	/** The url. */
	public String url;

	/** The dimension. */
	public String dimension;

	/** The residents. */
	public List<String> residents;

}
