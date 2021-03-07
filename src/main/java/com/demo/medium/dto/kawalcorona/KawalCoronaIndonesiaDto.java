package com.demo.medium.dto.kawalcorona;

import java.io.Serializable;

import lombok.Data;

@Data
public class KawalCoronaIndonesiaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String positif;
	private String sembuh;
	private String meninggal;
	private String dirawat;
}
