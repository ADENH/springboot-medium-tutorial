package com.demo.medium.service;

import java.util.List;

import com.demo.medium.dto.kawalcorona.KawalCoronaDto;
import com.demo.medium.dto.kawalcorona.KawalCoronaIndonesiaDto;
import com.demo.medium.dto.response.ResponseTemplate;

public interface KawalCoronaService {
	ResponseTemplate<List<KawalCoronaIndonesiaDto>> getDataCoronaIndonesia();
	ResponseTemplate<List<KawalCoronaIndonesiaDto>> getDataCoronaArab();
	ResponseTemplate<List<KawalCoronaDto>> getDataCoronaDunia();
}
