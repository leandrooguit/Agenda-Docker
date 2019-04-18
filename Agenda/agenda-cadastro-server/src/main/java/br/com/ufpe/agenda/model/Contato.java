package br.com.ufpe.agenda.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Contato")
public class Contato implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	
	@NotEmpty(message = "O nome é obrigatório.")
	@Column(name = "Nome", length = 50, nullable = false)
	private String nome;
	
	@Email
    @Size(min = 0, max = 50)
	@Column(name = "Email", length = 50, nullable = true)
	private String email;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "DataCadastro", nullable = false)
	private Date dataCadastro;
	
	@NotNull(message = "O telefone é obrigatório. Informe pelo menos um telefone.")
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones;

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}
