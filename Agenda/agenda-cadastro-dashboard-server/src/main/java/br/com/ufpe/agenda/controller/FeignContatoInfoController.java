package br.com.ufpe.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufpe.agenda.model.ContatoDtoInfo;
import br.com.ufpe.agenda.service.ContatoServiceProxy;

@RefreshScope
@RestController
public class FeignContatoInfoController {

	@Autowired
	private ContatoServiceProxy proxyService;
	
	@RequestMapping(value = "/dashboard/feign", method = RequestMethod.POST)
    public ResponseEntity<ContatoDtoInfo> save(@RequestBody ContatoDtoInfo dto) {
		return proxyService.save(dto);
    }
	
	@RequestMapping(value = "/dashboard/feign/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContatoDtoInfo> findById(@PathVariable("id") Integer id) {
		return proxyService.findById(id);
    }
	
	@RequestMapping(value = "/dashboard/feign", method = RequestMethod.GET)
    public ResponseEntity<List<ContatoDtoInfo>> findAll() {
        return proxyService.findAll();
    }
	
	@RequestMapping(value = "/dashboard/feign/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return proxyService.delete(id);
    }
	
}
