package br.com.ufpe.agenda.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ufpe.agenda.exception.NegocioException;
import br.com.ufpe.agenda.mapping.Mapeador;
import br.com.ufpe.agenda.model.Contato;
import br.com.ufpe.agenda.model.ContatoDto;
import br.com.ufpe.agenda.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value = "/api/v1/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private Mapeador mapeador;
	
	@ApiOperation(value = "Cadastrar Novo Contato",
            response = ContatoDto.class,
            notes = "Essa operacao salva um novo contato.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna a uri do novo contato cadastrado.",
                    response = ContatoDto.class)
    )
	@PostMapping
    public ResponseEntity<Void> save(@RequestBody ContatoDto dto) throws NegocioException {
		Contato contato = mapeador.getInstancia().map(dto, Contato.class);
		contato = contatoService.save(contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }
	
	@ApiOperation(value = "Listar um Contato",
            response = ContatoDto.class,
            notes = "Essa operacao retorna um contato.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma instancia de um objeto Contato.",
                    response = ContatoDto.class)
    )
	@GetMapping(value = "/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable("id") Integer id) throws NegocioException {
		Contato contato = contatoService.findById(id);
		ContatoDto dto = mapeador.getInstancia().map(contato, ContatoDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
	
	@ApiOperation(value = "Listar Contatos",
            response = ContatoDto.class,
            notes = "Essa operacao retorna todas os contatos cadastrados.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna uma lista do tipo contato.",
                    response = ContatoDto.class,
                    responseContainer = "List")
    )
	@GetMapping
    public ResponseEntity<List<ContatoDto>> findAll() {
		List<ContatoDto> dtos = mapeador.getInstancia().mapAsList(contatoService.findAll(), ContatoDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
	
	@ApiOperation(value = "Deleta um Contato",
            response = ContatoDto.class,
            notes = "Essa operacao deleta um contato.")
    @ApiResponses(
            @ApiResponse(code=200,
                    message = "Retorna o status 204.",
                    response = ContatoDto.class)
    )
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws NegocioException {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
	
}
