package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.NaoEncontrado;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.LivroDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Autor;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Editora;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Livro;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.LivroRN;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class LivroService extends Servico<Livro> {

    @Autowired
    LivroDAO livroDAO;

    @Autowired
    LivroRN regraNegocio;

    @Override
    public CrudRepository<Livro, Integer> getDAO() {
        return livroDAO;
    }

    @Override
    public RegraNegocio<Livro> getRegraNegocio() {
        return regraNegocio;
    }

//    AUTOR
    public void associarAutor(int idLivro, Autor autor) throws Throwable {
        Livro livro = this.recuperar(idLivro);
        livro.getAutores().add(autor);
        livroDAO.save(livro);
    }

    public void desassociarAutor(int idLivro, int idAutor) throws Throwable {
        Livro livro = this.recuperar(idLivro);
        List<Autor> autores = livro.getAutores();
        for (Autor autor : autores) {
            if (autor.getId() == idAutor) {
                livro.getAutores().remove(autor);
                livroDAO.save(livro);
                return;
            }

        }
        throw new NaoEncontrado("id " + idAutor + " não foi encontrada");
    }

    public List<Autor> listarAutor(int idLivro) throws Throwable {
        return this.recuperar(idLivro).getAutores();
    }

    public Autor recuperarAutor(int idLivro, int id) throws Throwable {
        Livro livro = this.recuperar(idLivro);
        List<Autor> autores = livro.getAutores();
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        throw new NaoEncontrado("id " + id + " não foi encontrada");
    }

//    EDITORA
    public void associarEditora(int idLivro, Editora editor) throws Throwable {
        Livro livro = this.recuperar(idLivro);
        livro.getEditoras().add(editor);
        livroDAO.save(livro);
    }

    public void desassociarEditora(int idLivro, int idEditora) throws Throwable {
        Livro livro = this.recuperar(idLivro);
        List<Editora> editores = livro.getEditoras();
        for (Editora editor : editores) {
            if (editor.getId() == idEditora) {
                livro.getEditoras().remove(editor);
                livroDAO.save(livro);
                return;
            }

        }
        throw new NaoEncontrado("id " + idEditora + " não foi encontrada");
    }

    public List<Editora> listarEditora(int idLivro) throws Throwable {
        return this.recuperar(idLivro).getEditoras();
    }

    public Editora recuperarEditora(int idLivro, int id) throws Throwable {
        Livro livro = this.recuperar(idLivro);
        List<Editora> editores = livro.getEditoras();
        for (Editora editor : editores) {
            if (editor.getId() == id) {
                return editor;
            }
        }
        throw new NaoEncontrado("id " + id + " não foi encontrada");
    }
}
