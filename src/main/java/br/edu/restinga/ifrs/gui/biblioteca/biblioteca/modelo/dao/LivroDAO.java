package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroDAO extends CrudRepository<Livro, Integer> {
    
}
