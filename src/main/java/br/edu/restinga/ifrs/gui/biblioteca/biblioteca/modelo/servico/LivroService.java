package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.LivroDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.LivroRN;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class LivroService extends Servico<Livro> {

    @Autowired
    LivroDAO dao;

    @Autowired
    LivroRN regraNegocio;

    @Override
    public CrudRepository<Livro, Integer> getDAO() {
        return dao;
    }

    @Override
    public RegraNegocio<Livro> getRegraNegocio() {
        return regraNegocio;
    }
}
