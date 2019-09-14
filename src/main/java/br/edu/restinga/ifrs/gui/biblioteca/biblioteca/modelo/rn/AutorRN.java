package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.AutorDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorRN implements RegraNegocio<Autor> {

    @Autowired
    AutorDAO autorDAO;

    @Override
    public void validarCadastrar(Autor entidade) {
        this.valida(entidade);
    }

    @Override
    public void validarAtualizar(Autor entidadeAtinga, Autor entidadeNova) {
        this.valida(entidadeNova);
    }

    @Override
    public void validarExcluir(Autor entidade) {
    }

    private void valida(Autor entidade) {
        if (entidade.getPrimeiroNome() == null
                || entidade.getSegundoNome() == null
                || entidade.getPrimeiroNome().equals("")
                || entidade.getSegundoNome().equals("")) {
            throw new QuebraRegraNegocio("Todos os campos são obrigatórios");
        }

        Iterable<Autor> findAll = autorDAO.findAll();
        for (Autor autorbanco : findAll) {
            if (entidade.getId() != autorbanco.getId()) {
                if (entidade.getPrimeiroNome().equals(autorbanco.getPrimeiroNome())
                        && entidade.getSegundoNome().equals(autorbanco.getSegundoNome())) {
                    throw new QuebraRegraNegocio("Não podem ser cadastrados dois "
                            + "autores com o mesmo 'primeiroNome' e 'segundoNome'");
                }
            }
        }
    }

}
