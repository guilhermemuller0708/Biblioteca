package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroRN implements RegraNegocio<Livro> {

    @Override
    public void validarCadastrar(Livro entidade) {
        this.valida(entidade);
    }

    @Override
    public void validarAtualizar(Livro entidadeAtinga, Livro entidadeNova) {
        this.valida(entidadeNova);
    }

    @Override
    public void validarExcluir(Livro entidade) {

    }

    private void valida(Livro entidade) {
        if (entidade.getTitulo() == null
                || entidade.getTitulo().equals("")
                || entidade.getAnoPublicacao() == 0) {
            throw new QuebraRegraNegocio("Todos os campos são obrigatórios");
        }
    }

}
