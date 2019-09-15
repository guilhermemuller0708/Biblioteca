package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.EmprestimoDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Emprestimo;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoRN implements RegraNegocio<Emprestimo> {
    
    @Autowired
    EmprestimoDAO emprestimoDAO;
    
    @Override
    public void validarCadastrar(Emprestimo entidade) {
//        add retirada
        entidade.setRetirada(Calendar.getInstance());

//        add previsao +7 dias
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, +7);
        entidade.setPrevisaoDevolucao(c);
        
        this.valida(entidade);
        this.livroEmprestado(entidade.getLivro());
    }
    
    @Override
    public void validarAtualizar(Emprestimo entidadeAtinga, Emprestimo entidadeNova) {
        this.valida(entidadeNova);
    }
    
    @Override
    public void validarExcluir(Emprestimo entidade) {
    }
    
    private void valida(Emprestimo entidade) {
        if (entidade.getBibliotecario() == null
                || entidade.getBibliotecario().equals("")
                || entidade.getLivro() == null
                || entidade.getLivro().equals("")
                || entidade.getUsuario() == null
                || entidade.getUsuario().equals("")) {
            throw new QuebraRegraNegocio("Livro, usuário e bibliotecário são obrigatórios");
        }
        if (entidade.getDevolucao() != null) {
            if (entidade.getDevolucao().equals(Calendar.getInstance())
                    || entidade.getDevolucao().after(Calendar.getInstance())) {
                throw new QuebraRegraNegocio("Data de devolução deve ser igual"
                        + " ou menor que a data atual");
            }
        }
    }
    
    private void livroEmprestado(Livro livro) {
        Iterable<Emprestimo> findAll = emprestimoDAO.findAll();
        for (Emprestimo emprestimo : findAll) {
            if (emprestimo.getLivro().getId() == livro.getId() && emprestimo.getDevolucao() == null) {
                throw new QuebraRegraNegocio("Não pode fazer empréstimo de um livro que não foi devolvido");
            }
        }
    }
}
