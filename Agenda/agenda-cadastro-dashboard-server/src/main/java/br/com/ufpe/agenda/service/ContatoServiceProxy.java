package br.com.ufpe.agenda.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufpe.agenda.model.ContatoDtoInfo;

@FeignClient(name = "agenda-cadastro")
@RibbonClient(name = "agenda-cadastro")
public interface ContatoServiceProxy {

	@RequestMapping(value = "/api/contatos", method = RequestMethod.POST)
	public ResponseEntity<ContatoDtoInfo> save(@RequestBody ContatoDtoInfo dto);
	
	@RequestMapping(value = "/api/contatos/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContatoDtoInfo> findById(@PathVariable("id") Integer id);
	
	@RequestMapping(value = "/api/contatos", method = RequestMethod.GET)
    public ResponseEntity<List<ContatoDtoInfo>> findAll();
	
	@RequestMapping(value = "/api/contatos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id);
	
}
