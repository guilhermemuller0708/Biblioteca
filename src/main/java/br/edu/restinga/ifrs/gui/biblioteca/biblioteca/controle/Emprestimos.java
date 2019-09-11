package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Emprestimo;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.EmprestimoServico;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emprestimos")
public class Emprestimos extends CRUDControle<Emprestimo> {

    @Autowired
    EmprestimoServico servico;

    @Override
    public Servico<Emprestimo> getService() {
        return servico;
    }
}
