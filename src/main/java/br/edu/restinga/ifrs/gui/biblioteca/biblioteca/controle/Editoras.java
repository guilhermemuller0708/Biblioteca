package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Editora;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.EditoraService;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/editoras")
public class Editoras extends CRUDControle<Editora> {

    @Autowired
    EditoraService servico;

    @Override
    public Servico<Editora> getService() {
        return servico;
    }
}
