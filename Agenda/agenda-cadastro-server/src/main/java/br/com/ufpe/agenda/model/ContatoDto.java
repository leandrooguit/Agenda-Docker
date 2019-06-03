package br.com.ufpe.agenda.model;

import java.util.List;

import lombok.Data;

@Data
public class ContatoDto {

	private Integer id;
	private String nome;
	private String email;
	private List<TelefoneDto> telefones;
	
	@Data
	public static class TelefoneDto {
		private Integer id;
		private Integer numero;
		private Integer ddd;
	}
	
}
