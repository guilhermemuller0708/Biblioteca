package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.LivroService;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livros")
public class Livros extends CRUDControle<Livro> {

    @Autowired
    LivroService servico;

    @Override
    public Servico<Livro> getService() {
        return servico;
    }
}
