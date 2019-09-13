package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Emprestimo;
import java.util.Calendar;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoRN implements RegraNegocio<Emprestimo> {

    @Override
    public void validarCadastrar(Emprestimo entidade) {
        if (entidade.getBibliotecario() == null
                || entidade.getBibliotecario().equals("")
                || entidade.getLivro() == null
                || entidade.getLivro().equals("")
                || entidade.getUsuario() == null
                || entidade.getUsuario().equals("")) {
            throw new QuebraRegraNegocio("livro, usuário e bibliotecário são obrigatórios");
        }
        if (entidade.getRetirada().after(Calendar.getInstance())
                || entidade.getDevolucao().equals(Calendar.getInstance())) {
            throw new QuebraRegraNegocio("Data de retirada deve ser "
                    + "definida pelo servidor utilizando a data atual");

        }
//        if (entidade.getPrevisaoDevolucao().(Calendar.getInstance())) {
//            throw new QuebraRegraNegocio("Data de previsão de devolução deve ser "
//                    + "definida pelo servidor utilizando a data atual somando 7 dias");  
//        }
        if (entidade.getDevolucao().equals(Calendar.getInstance())
                || entidade.getDevolucao().before(Calendar.getInstance())) {
            throw new QuebraRegraNegocio("Data de devolução deve ser igual"
                    + " ou menor que a data atual");

        }
        if (true) {
            throw new QuebraRegraNegocio("Não pode ser cadastrado um empréstimo"
                    + " de um livro que ainda não foi devolvido");

        }

    }

    @Override
    public void validarAtualizar(Emprestimo entidadeAtinga, Emprestimo entidadeNova) {
        if (true) {

        }
    }

    @Override
    public void validarExcluir(Emprestimo entidade) {
        if (true) {

        }
    }

}
