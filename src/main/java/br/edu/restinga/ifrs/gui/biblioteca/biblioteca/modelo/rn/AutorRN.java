package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorRN implements RegraNegocio<Autor> {

    @Override
    public void validarCadastrar(Autor entidade) {
        if (true) {

        }
    }

    @Override
    public void validarAtualizar(Autor entidadeAtinga, Autor entidadeNova) {
        if (true) {

        }
    }

    @Override
    public void validarExcluir(Autor entidade) {
        if (true) {

        }
    }

}
