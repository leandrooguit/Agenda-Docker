package br.com.ufpe.agenda.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufpe.agenda.model.ContatoDtoInfo;

@FeignClient(name = "agenda-cadastro-service", url = "http://agenda-cadastro:9092")
public interface ContatoServiceProxy {

	@RequestMapping(value = "/api/contatos", method = RequestMethod.GET)
    public ResponseEntity<List<ContatoDtoInfo>> findAll();
	
}
