package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Bibliotecario;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.BibliotecarioService;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bibliotecarios")
public class Bibliotecarios extends CRUDControle<Bibliotecario> {

    @Autowired
    BibliotecarioService servico;

    @Override
    public Servico<Bibliotecario> getService() {
        return servico;
    }
}
