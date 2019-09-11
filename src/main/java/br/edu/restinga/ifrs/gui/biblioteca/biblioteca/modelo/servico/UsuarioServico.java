package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.UsuarioDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Usuario;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.UsuarioRN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServico extends Servico<Usuario> {

    @Autowired
    UsuarioDAO dao;

    @Autowired
    UsuarioRN regraNegocio;

    @Override
    public CrudRepository<Usuario, Integer> getDAO() {
        return dao;
    }

    @Override
    public RegraNegocio<Usuario> getRegraNegocio() {
        return regraNegocio;
    }
}
