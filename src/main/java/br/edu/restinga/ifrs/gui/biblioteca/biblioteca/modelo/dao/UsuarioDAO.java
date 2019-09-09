package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    
}
