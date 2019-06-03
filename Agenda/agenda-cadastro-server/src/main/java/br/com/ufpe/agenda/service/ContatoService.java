package br.com.ufpe.agenda.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.ufpe.agenda.model.Contato;
import br.com.ufpe.agenda.model.ContatoDto;
import br.com.ufpe.agenda.model.Telefone;
import br.com.ufpe.agenda.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato save(@Validated Contato contato) {
		contato.setDataCadastro(new Date());
        return contatoRepository.save(contato);
    }
	
	public Contato findById(Integer id){
        return contatoRepository.findOne(id);
    }
	
	public Iterable<Contato> findAll(){
        return contatoRepository.findAll();
    }
	
	public void delete(Integer id) {
        contatoRepository.delete(id);
    }
	
	public Contato converterToContato(ContatoDto dto) {
		Contato contato = new Contato();
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		List<Telefone> telefones = new ArrayList<Telefone>();
		for (ContatoDto.TelefoneDto telefoneDto : dto.getTelefones()) {
			Telefone telefone = new Telefone();
			telefone.setNumero(telefoneDto.getNumero());
			telefone.setDdd(telefoneDto.getDdd());
			telefone.setContato(contato);
			telefones.add(telefone);
		}
		contato.setTelefones(telefones);
		return contato;
	}
	
	public ContatoDto converterToContatoDto(Contato contato) {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setId(contato.getId());
		contatoDto.setNome(contato.getNome());
		contatoDto.setEmail(contato.getEmail());
		List<ContatoDto.TelefoneDto> telefonesDto = new ArrayList<ContatoDto.TelefoneDto>();
		for (Telefone telefone : contato.getTelefones()) {
			ContatoDto.TelefoneDto telefoneDto = new ContatoDto.TelefoneDto();
			telefoneDto.setId(telefone.getId());
			telefoneDto.setNumero(telefone.getNumero());
			telefoneDto.setDdd(telefone.getDdd());
			telefonesDto.add(telefoneDto);
		}
		contatoDto.setTelefones(telefonesDto);
		return contatoDto;
	}
	
	public List<ContatoDto> converterToContatoDto(Iterable<Contato> contatos) {
		List<ContatoDto> contatosDto = new ArrayList<ContatoDto>();
		for (Contato contato : contatos) {
			ContatoDto contatoDto = converterToContatoDto(contato);
			contatosDto.add(contatoDto);
		}
		return contatosDto;
	}
	
}
