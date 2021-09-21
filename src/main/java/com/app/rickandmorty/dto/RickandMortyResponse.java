package com.app.rickandmorty.dto;

import lombok.Data;


/**
 * The Class RickandMortyResponse.
 */

/**
 * Instantiates a new rickand morty response.
 */
@Data
public class RickandMortyResponse {

	/** The id. */
	public int id;
    
    /** The name. */
    public String name;
    
    /** The status. */
    public String status;
    
    /** The species. */
    public String species;
    
    /** The type. */
    public String type;
    
    /** The episode count. */
    public int episode_count;
    
    /** The origin. */
    public OriginResponse origin;

}
