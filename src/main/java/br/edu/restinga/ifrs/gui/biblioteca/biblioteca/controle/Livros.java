package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.controle;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Editora;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.EditoraService;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.LivroService;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico.Servico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livros")
public class Livros extends CRUDControle<Livro> {

    @Autowired
    LivroService livroServico;

    @Autowired
    EditoraService editoraService;

    @Override
    public Servico<Livro> getService() {
        return livroServico;
    }

//    AUTORES
    @RequestMapping(path = "/{idLivro}/autores/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void associarAutor(@PathVariable int idLivro, @RequestBody Autor autor) throws Throwable {
        livroServico.associarAutor(idLivro, autor);
    }

    @DeleteMapping("/{idLivro}/autores/{idAutor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarAutor(@PathVariable int idLivro, @PathVariable int idAutor) throws Throwable {
        livroServico.desassociarAutor(idLivro, idAutor);
    }

    @RequestMapping(path = "/{idLivro}/autores/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Autor> listarAutor(@PathVariable int idLivro) throws Throwable {
        return this.recuperar(idLivro).getAutores();
    }

    @GetMapping("/{idLivro}/autores/{idAutor}")
    @ResponseStatus(HttpStatus.OK)
    public Autor recuperarAutor(@PathVariable int idLivro, @PathVariable int idAutor) throws Throwable {
        return livroServico.recuperarAutor(idLivro, idAutor);
    }

//    EDITORAS
    @RequestMapping(path = "/{idLivro}/editoras/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void associarEditora(@PathVariable int idLivro, @RequestBody Editora editora) throws Throwable {
        livroServico.associarEditora(idLivro, editora);
    }

    @DeleteMapping("/{idLivro}/editoras/{idEditora}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarEditora(@PathVariable int idLivro, @PathVariable int idEditora) throws Throwable {
        livroServico.desassociarEditora(idLivro, idEditora);
    }

    @RequestMapping(path = "/{idLivro}/editoras/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Editora> listarEditora(@PathVariable int idLivro) throws Throwable {
        return this.recuperar(idLivro).getEditoras();
    }

    @GetMapping("/{idLivro}/editoras/{idEditora}")
    @ResponseStatus(HttpStatus.OK)
    public Editora recuperarEditora(@PathVariable int idLivro, @PathVariable int idEditora) throws Throwable {
        return livroServico.recuperarEditora(idLivro, idLivro);
    }
}
