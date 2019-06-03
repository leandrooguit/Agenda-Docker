package br.com.ufpe.agenda.model;

import java.util.List;

public class ContatoDtoInfo {

	private Integer id;
	private String nome;
	private String email;
	private List<TelefoneDtoInfo> telefones;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TelefoneDtoInfo> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDtoInfo> telefones) {
		this.telefones = telefones;
	}

	public static class TelefoneDtoInfo {
		private Integer id;
		private Integer numero;
		private Integer ddd;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getNumero() {
			return numero;
		}
		
		public void setNumero(Integer numero) {
			this.numero = numero;
		}
		
		public Integer getDdd() {
			return ddd;
		}
		
		public void setDdd(Integer ddd) {
			this.ddd = ddd;
		}
		
	}
	
}
