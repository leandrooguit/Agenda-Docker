package br.com.ufpe.agenda.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ufpe.agenda.model.ContatoDtoInfo;

@FeignClient(name = "agenda-cadastro-service", url = "${feign.client.url.TestUrl}")
public interface ContatoServiceProxy {

	@GetMapping(value = "/api/v1/contatos")
    public ResponseEntity<List<ContatoDtoInfo>> findAll();
	
}
