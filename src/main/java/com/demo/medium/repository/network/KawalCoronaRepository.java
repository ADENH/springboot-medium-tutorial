package com.demo.medium.repository.network;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.medium.dto.kawalcorona.KawalCoronaIndonesiaDto;

@FeignClient(name = "kawal-corona", url = "${kawal-corona.url}")
public interface KawalCoronaRepository {
	
	@GetMapping("/indonesia/")
	public List<KawalCoronaIndonesiaDto> getDataCoronaIndonesia();

}
