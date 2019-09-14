package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.QuebraRegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.EditoraDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditoraRN implements RegraNegocio<Editora> {

    @Autowired
    EditoraDAO editoraDAO;

    @Override
    public void validarCadastrar(Editora entidade) {
        this.valida(entidade);
    }

    @Override
    public void validarAtualizar(Editora entidadeAtinga, Editora entidadeNova) {
        this.valida(entidadeNova);
    }

    @Override
    public void validarExcluir(Editora entidade) {

    }

    private void valida(Editora entidade) {
        if (entidade.getNome() == null
                || entidade.getNome().equals("")) {
            throw new QuebraRegraNegocio("Todos os campos são obrigatórios");
        }

        Iterable<Editora> findAll = editoraDAO.findAll();
        for (Editora editoraBanco : findAll) {
            if (entidade.getId() != editoraBanco.getId()) {
                if (entidade.getCnpj().equals(editoraBanco.getCnpj())) {
                    throw new QuebraRegraNegocio("Cnpj não pode ser repetido");
                }
            }
        }
    }

}
