package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.BibliotecarioDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Bibliotecario;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.BibliotecarioRN;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class BibliotecarioService extends Servico<Bibliotecario> {

    @Autowired
    BibliotecarioDAO dao;

    @Autowired
    BibliotecarioRN regraNegocio;

    @Override
    public CrudRepository<Bibliotecario, Integer> getDAO() {
        return dao;
    }

    @Override
    public RegraNegocio<Bibliotecario> getRegraNegocio() {
        return regraNegocio;
    }
}
