package br.com.ufpe.agenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Telefone")
@Table(name = "Telefone")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Telefone implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotNull(message = "O numero e obrigatorio.")
	@Column(name = "Numero", nullable = false)
	private Integer numero;
	
	@NotNull(message = "O ddd e obrigatorio.")
	@Column(name = "DDD", nullable = false)
	private Integer ddd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Contato_Id", nullable = false)
	private Contato contato;

}
