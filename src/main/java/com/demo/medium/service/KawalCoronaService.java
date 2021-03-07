package com.demo.medium.service;

import java.util.List;

import com.demo.medium.dto.kawalcorona.KawalCoronaDto;
import com.demo.medium.dto.kawalcorona.KawalCoronaIndonesiaDto;

public interface KawalCoronaService {
	List<KawalCoronaIndonesiaDto> getDataCoronaIndonesia();
	List<KawalCoronaDto> getDataCoronaDunia();
}
