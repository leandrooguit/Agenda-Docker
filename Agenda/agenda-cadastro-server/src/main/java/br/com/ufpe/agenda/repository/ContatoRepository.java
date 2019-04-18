package br.com.ufpe.agenda.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ufpe.agenda.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {

}
