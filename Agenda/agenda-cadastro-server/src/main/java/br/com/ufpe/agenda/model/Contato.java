package br.com.ufpe.agenda.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

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
	
	@NotBlank(message = "error-2")
	@Column(name = "Nome", length = 50, nullable = false)
	private String nome;
	
	@Email
    @Size(min = 0, max = 50)
	@NotBlank(message = "error-3")
	@Column(name = "Email", length = 50, nullable = false)
	private String email;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "DataCadastro", nullable = false)
	private Date dataCadastro;
	
	@NotNull(message = "error-4")
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones;

}
