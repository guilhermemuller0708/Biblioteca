package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.servico;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.excecoes.NaoEncontrado;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.TelefoneDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao.UsuarioDAO;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Telefone;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Usuario;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.RegraNegocio;
import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.rn.UsuarioRN;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServico extends Servico<Usuario> {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    TelefoneDAO telefoneDAO;

    @Autowired
    UsuarioRN regraNegocio;

    @Override
    public CrudRepository<Usuario, Integer> getDAO() {
        return usuarioDAO;
    }

    @Override
    public RegraNegocio<Usuario> getRegraNegocio() {
        return regraNegocio;
    }

    public Telefone cadastrarTelefone(int idUsuario, Telefone telefone) throws Throwable {
        Usuario usuario = this.recuperar(idUsuario);
        telefone.setId(0);
        Telefone telefoneBanco = telefoneDAO.save(telefone);
        usuario.getTelefones().add(telefoneBanco);
        usuarioDAO.save(usuario);
        return telefoneBanco;
    }

    public Telefone recuperarTelefone(int idUsuario, int idTelefone) throws Throwable {
        Usuario usuario = this.recuperar(idUsuario);
        List<Telefone> telefones = usuario.getTelefones();

        for (Telefone telefone : telefones) {
            if (telefone.getId() == idTelefone) {
                return telefone;
            }
        }

        throw new NaoEncontrado("id " + idTelefone + " não foi encontrada");
    }

    public void atualizarTelefone(int idUsuario, Telefone telefone) throws Throwable {
        this.recuperarTelefone(idUsuario, telefone.getId());
        telefoneDAO.save(telefone);
    }

    public List<Telefone> listarTelefone(int idUsuario) throws Throwable {
        return this.recuperar(idUsuario).getTelefones();
    }

    public void excluirTelefone(int idUsuario, int idTelefone) throws Throwable {
        Usuario usuario = this.recuperar(idUsuario);
        List<Telefone> telefones = usuario.getTelefones();
        for (Telefone telefone : telefones) {
            if (telefone.getId() == idTelefone) {
                usuario.getTelefones().remove(telefone);
                usuarioDAO.save(usuario);
                return;
            }
        }
        throw new NaoEncontrado("id " + idTelefone + " nao foi encontrada");
    }
}
