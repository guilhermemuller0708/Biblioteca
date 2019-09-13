package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroRN implements RegraNegocio<Livro> {

    @Override
    public void validarCadastrar(Livro entidade) {
        if (entidade.getTitulo() == null
                || entidade.getTitulo().equals("")
                || entidade.getAnoPublicacao() == 0) {
            throw new QuebraRegraNegocio("Todos os campos são obrigatórios");
        }
    }

    @Override
    public void validarAtualizar(Livro entidadeAtinga, Livro entidadeNova) {
        if (true) {

        }
    }

    @Override
    public void validarExcluir(Livro entidade) {
        if (true) {

        }
    }

}
