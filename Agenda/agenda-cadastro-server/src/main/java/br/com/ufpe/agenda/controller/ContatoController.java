package br.com.ufpe.agenda.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufpe.agenda.model.Contato;
import br.com.ufpe.agenda.model.ContatoDto;
import br.com.ufpe.agenda.service.ContatoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/contatos",  produces = MediaType.APPLICATION_JSON_VALUE)
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ContatoDto> save(@RequestBody ContatoDto dto) {
		Contato contato = contatoService.converterToContato(dto);
		contato = contatoService.save(contato);
		dto = contatoService.converterToContatoDto(contato);
		return ResponseEntity.ok().body(dto);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContatoDto> findById(@PathVariable("id") Integer id) {
		Contato contato = contatoService.findById(id);
		ContatoDto dto = contatoService.converterToContatoDto(contato);
		return ResponseEntity.ok().body(dto);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ContatoDto>> findAll() {
		List<ContatoDto> dtos = contatoService.converterToContatoDto(contatoService.findAll());
        return ResponseEntity.ok().body(dtos);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
	
}
