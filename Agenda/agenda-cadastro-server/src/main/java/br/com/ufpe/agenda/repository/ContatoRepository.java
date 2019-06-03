package br.com.ufpe.agenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufpe.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

	Optional<Contato> findByEmail(String email);
	
	Optional<Contato> findById(Integer id);
	
}
