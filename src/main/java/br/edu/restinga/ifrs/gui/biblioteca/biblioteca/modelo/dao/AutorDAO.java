package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends CrudRepository<Autor, Integer> {

}
