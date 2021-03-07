package com.demo.medium.dto.kawalcorona;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Attributes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8107243230024614522L;

	@JsonProperty("OBJECTID")
	private Long objectId;
	
	@JsonProperty("Country_Region")
	private String countryRegion;
	
	@JsonProperty("Last_Update")
	private Long lastUpdate;
	
	@JsonProperty("Lat")
	private Long latitude;
	
	@JsonProperty("Long_")
	private Long longitude;
	
	@JsonProperty("Confirmed")
	private Long confirmed;
	
	@JsonProperty("Deaths")
	private Long deaths;
	
	@JsonProperty("Recovered")
	private Long recovered;
	
	@JsonProperty("Active")
	private Long active;
	
}
