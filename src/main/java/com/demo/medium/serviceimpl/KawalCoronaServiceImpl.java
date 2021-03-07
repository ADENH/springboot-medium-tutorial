package com.demo.medium.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.medium.dto.kawalcorona.KawalCoronaDto;
import com.demo.medium.dto.kawalcorona.KawalCoronaIndonesiaDto;
import com.demo.medium.repository.network.KawalCoronaRepository;
import com.demo.medium.service.KawalCoronaService;

@Service
public class KawalCoronaServiceImpl implements KawalCoronaService {

	@Autowired
	KawalCoronaRepository kawalCoronaRepository;

	@Override
	@Cacheable(value = "dataCoronaIndonesia")
	public List<KawalCoronaIndonesiaDto> getDataCoronaIndonesia() { 
		return kawalCoronaRepository.getDataCoronaIndonesia();
	}

	@Override
	@Cacheable(value = "data")
	public List<KawalCoronaDto> getDataCoronaDunia() {
		return kawalCoronaRepository.getDataCoronaDunia();
	}

}
