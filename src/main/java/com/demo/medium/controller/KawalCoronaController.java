package com.demo.medium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.medium.dto.kawalcorona.KawalCoronaDto;
import com.demo.medium.dto.kawalcorona.KawalCoronaIndonesiaDto;
import com.demo.medium.service.KawalCoronaService;

@RestController
@RequestMapping("/api/corona")
public class KawalCoronaController {

	@Autowired
	KawalCoronaService kawalCoronaService;
	
	@GetMapping("/indonesia")
	public List<KawalCoronaIndonesiaDto> getDataCoronaIndonesia(){
		return kawalCoronaService.getDataCoronaIndonesia();
	}
	
	@GetMapping
	public List<KawalCoronaDto> getDataCoronaDunia(){
		return kawalCoronaService.getDataCoronaDunia();
	}
}
