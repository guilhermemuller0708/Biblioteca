package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.AutorDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.AutorRN;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class AutorService extends Servico<Autor> {

    @Autowired
    AutorDAO dao;

    @Autowired
    AutorRN regraNegocio;

    @Override
    public CrudRepository<Autor, Integer> getDAO() {
        return dao;
    }

    @Override
    public RegraNegocio<Autor> getRegraNegocio() {
        return regraNegocio;
    }
}
