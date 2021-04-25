package com.demo.medium.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.medium.dto.kawalcorona.KawalCoronaDto;
import com.demo.medium.dto.kawalcorona.KawalCoronaIndonesiaDto;
import com.demo.medium.dto.response.ResponseTemplate;
import com.demo.medium.repository.network.KawalCoronaRepository;
import com.demo.medium.service.KawalCoronaService;
import com.demo.medium.service.ResponseService;

@Service
public class KawalCoronaServiceImpl implements KawalCoronaService {

	@Autowired
	KawalCoronaRepository kawalCoronaRepository;
	
	@Autowired
	ResponseService responseService;

	@Override
	@Cacheable(value = "dataCoronaIndonesia")
	public ResponseTemplate<List<KawalCoronaIndonesiaDto>> getDataCoronaIndonesia() { 
		return responseService.apiSuccess(kawalCoronaRepository.getDataCoronaIndonesia());
	}

	@Override
	@Cacheable(value = "data")
	public ResponseTemplate<List<KawalCoronaDto>> getDataCoronaDunia() {
		return responseService.apiSuccess(kawalCoronaRepository.getDataCoronaDunia());
	}

	@Override
	public ResponseTemplate<List<KawalCoronaIndonesiaDto>> getDataCoronaArab() {
		return responseService.apiSuccess(kawalCoronaRepository.getDataCoronaArab());
	}

}
