package br.com.ufpe.agenda.model;

import org.hibernate.validator.constraints.Email;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "Contato")
@Table(name = "Contato")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contato implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotNull(message = "O nome e obrigatorio.")
	@Column(name = "Nome", length = 50, nullable = false)
	private String nome;
	
	@Email(message = "O e-mail e invalido.")
    @Size(min = 0, max = 50)
	@NotNull(message = "O e-mail e obrigatorio.")
	@Column(name = "Email", length = 50, nullable = false)
	private String email;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "DataCadastro", nullable = false)
	private Date dataCadastro;
	
	@NotNull(message = "O telefone e obrigatorio. Informe pelo menos um telefone.")
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones;

}
