package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.AutorService;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autores")
public class Autores extends CRUDControle<Autor> {
    
    @Autowired
    AutorService servico;
    
    @Override
    public Servico<Autor> getService() {
        return servico;
    }
}
