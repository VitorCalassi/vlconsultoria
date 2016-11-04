package com.vlc.brewer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vlc.brewer.service.CadastroCervejaService;
import com.vlc.brewer.storage.FotoStorage;
import com.vlc.brewer.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}
	
}