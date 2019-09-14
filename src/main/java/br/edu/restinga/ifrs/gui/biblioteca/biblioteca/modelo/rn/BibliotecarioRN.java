package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.BibliotecarioDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Bibliotecario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BibliotecarioRN implements RegraNegocio<Bibliotecario> {

    @Autowired
    BibliotecarioDAO bibliotecarioDAO;

    @Override
    public void validarCadastrar(Bibliotecario entidade) {
        this.valida(entidade);
    }

    @Override
    public void validarAtualizar(Bibliotecario entidadeAtinga, Bibliotecario entidadeNova) {
        this.valida(entidadeNova);
    }

    @Override
    public void validarExcluir(Bibliotecario entidade) {

    }

    private void valida(Bibliotecario entidade) {
        if (entidade.getEmail() == null
                || entidade.getNome() == null
                || entidade.getSenha() == null
                || entidade.getEmail().equals("")
                || entidade.getNome().equals("")
                || entidade.getSenha().equals("")) {
            throw new QuebraRegraNegocio("Todos os campos são obrigatórios");
        }

        if (entidade.getSenha().length() < 8) {
            throw new QuebraRegraNegocio("Senha deve ter no mínimo 8 caracteres");
        }

        Iterable<Bibliotecario> findAll = bibliotecarioDAO.findAll();
        for (Bibliotecario bibliotecarioBanco : findAll) {
            if (entidade.getId() != bibliotecarioBanco.getId()) {
                if (entidade.getEmail().equals(bibliotecarioBanco.getEmail())) {
                    throw new QuebraRegraNegocio("E-mail não pode ser repetido");
                }
            }
        }
    }
}
