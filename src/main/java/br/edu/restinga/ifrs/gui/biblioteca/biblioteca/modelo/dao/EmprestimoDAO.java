package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Emprestimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoDAO extends CrudRepository<Emprestimo, Integer> {

}
