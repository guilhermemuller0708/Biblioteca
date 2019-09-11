package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Usuario;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class Usuarios extends CRUDControle<Usuario> {

    @Autowired
    UsuarioServico servico;

    @Override
    public Servico<Usuario> getService() {
        return servico;
    }
}
