package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.EmprestimoDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Emprestimo;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.EmprestimoRN;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoServico extends Servico<Emprestimo> {

    @Autowired
    EmprestimoDAO dao;

    @Autowired
    EmprestimoRN regraNegocio;

    @Override
    public CrudRepository<Emprestimo, Integer> getDAO() {
        return dao;
    }

    @Override
    public RegraNegocio<Emprestimo> getRegraNegocio() {
        return regraNegocio;
    }
}
