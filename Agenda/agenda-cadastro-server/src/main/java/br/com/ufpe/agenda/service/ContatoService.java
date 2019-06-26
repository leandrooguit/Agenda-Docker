package br.com.ufpe.agenda.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.ufpe.agenda.exception.NegocioException;
import br.com.ufpe.agenda.model.Contato;
import br.com.ufpe.agenda.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato save(@Validated Contato contato) throws NegocioException {
		Optional<Contato> contatoBase = contatoRepository.findByEmail(contato.getEmail());
		
		if (contatoBase.isPresent()) {
			throw new NegocioException("e-mail.existente", HttpStatus.BAD_REQUEST);
		}
		
		contato.setDataCadastro(new Date());
        return contatoRepository.saveAndFlush(contato);
    }
	
	public Contato findById(Integer id) throws NegocioException {
		Optional<Contato> contato =  contatoRepository.findById(id);
		
		if (!contato.isPresent()) {
			throw new NegocioException("nao-encontrado", HttpStatus.BAD_REQUEST);
		}
		
		return contato.get();
    }
	
	public Iterable<Contato> findAll(){
        return contatoRepository.findAll();
    }
	
	public void delete(Integer id) throws NegocioException {
		Contato contato = findById(id);
        contatoRepository.delete(contato);
    }
	
}
