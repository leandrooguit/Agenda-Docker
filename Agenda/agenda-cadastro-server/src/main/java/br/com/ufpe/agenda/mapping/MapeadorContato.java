package br.com.ufpe.agenda.mapping;

import br.com.ufpe.agenda.model.Contato;
import br.com.ufpe.agenda.model.ContatoDto;
import br.com.ufpe.agenda.model.Telefone;
import ma.glasnost.orika.CustomMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import ma.glasnost.orika.MappingContext;

@Service
@Mapear
public class MapeadorContato extends CustomMapper<Contato, ContatoDto> {

	@Override
	public void mapAtoB(Contato contato, ContatoDto dto, MappingContext context) {
		dto.setId(contato.getId());
		dto.setNome(contato.getNome());
		dto.setEmail(contato.getEmail());
		List<ContatoDto.TelefoneDto> telefonesDto = new ArrayList<ContatoDto.TelefoneDto>();
		for (Telefone telefone : contato.getTelefones()) {
			ContatoDto.TelefoneDto telefoneDto = new ContatoDto.TelefoneDto();
			telefoneDto.setId(telefone.getId());
			telefoneDto.setNumero(telefone.getNumero());
			telefoneDto.setDdd(telefone.getDdd());
			telefonesDto.add(telefoneDto);
		}
		dto.setTelefones(telefonesDto);
	}
	
	@Override
	public void mapBtoA(ContatoDto dto, Contato contato, MappingContext context) {
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
	}
	
}
