package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.EditoraDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Editora;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.EditoraRN;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class EditoraService extends Servico<Editora> {

    @Autowired
    EditoraDAO dao;

    @Autowired
    EditoraRN regraNegocio;

    @Override
    public CrudRepository<Editora, Integer> getDAO() {
        return dao;
    }

    @Override
    public RegraNegocio<Editora> getRegraNegocio() {
        return regraNegocio;
    }

}
