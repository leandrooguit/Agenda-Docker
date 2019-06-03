package br.com.ufpe.agenda.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ufpe.agenda.exception.NegocioException;
import br.com.ufpe.agenda.mapping.Mapeador;
import br.com.ufpe.agenda.model.Contato;
import br.com.ufpe.agenda.model.ContatoDto;
import br.com.ufpe.agenda.service.ContatoService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/contatos",  produces = MediaType.APPLICATION_JSON_VALUE)
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private Mapeador mapeador;
	
	@PostMapping
    public ResponseEntity<Void> save(@RequestBody ContatoDto dto) throws NegocioException {
		Contato contato = mapeador.getInstancia().map(dto, Contato.class);
		contato = contatoService.save(contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable("id") Integer id) throws NegocioException {
		Contato contato = contatoService.findById(id);
		ContatoDto dto = mapeador.getInstancia().map(contato, ContatoDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
	
	@GetMapping
    public ResponseEntity<List<ContatoDto>> findAll() {
		List<ContatoDto> dtos = mapeador.getInstancia().mapAsList(contatoService.findAll(), ContatoDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws NegocioException {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ContatoDto dto, 
			@PathVariable("id") Integer id) throws NegocioException {
		dto.setId(id);
		Contato contato = mapeador.getInstancia().map(dto, Contato.class);
		contatoService.update(contato);
		return ResponseEntity.noContent().build();
	}
	
}
