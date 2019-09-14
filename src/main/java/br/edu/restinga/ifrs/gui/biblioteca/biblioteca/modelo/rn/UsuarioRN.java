package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.UsuarioDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRN implements RegraNegocio<Usuario> {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public void validarCadastrar(Usuario entidade) {
        this.valida(entidade);
    }

    @Override
    public void validarAtualizar(Usuario entidadeAtinga, Usuario entidadeNova) {
        this.valida(entidadeNova);
    }

    @Override
    public void validarExcluir(Usuario entidade) {
    }

    private void valida(Usuario entidade) {
        if (entidade.getEmail() == null
                || entidade.getNome() == null
                || entidade.getCpf() == null
                || entidade.getEmail().equals("")
                || entidade.getNome().equals("")
                || entidade.getCpf().equals("")) {
            throw new QuebraRegraNegocio("Todos os campos são obrigatórios");
        }

        Iterable<Usuario> findAll = usuarioDAO.findAll();
        for (Usuario usuarioBanco : findAll) {
            if (entidade.getId() != usuarioBanco.getId()) {
                if (entidade.getEmail().equals(usuarioBanco.getEmail())
                        || entidade.getCpf().equals(usuarioBanco.getCpf())) {
                    throw new QuebraRegraNegocio("E-mail e cpf não podem ser repetidos");
                }
            }
        }

        if (entidade.getTelefones().size() > 3) {
            throw new QuebraRegraNegocio("O usuário não pode ter mais de 3 telefones");
        }
    }
}
