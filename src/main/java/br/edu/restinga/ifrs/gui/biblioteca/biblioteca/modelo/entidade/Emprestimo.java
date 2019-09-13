package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Calendar retirada;

    @Temporal(TemporalType.DATE)
    private Calendar previsaoDevolucao;

    @Temporal(TemporalType.DATE)
    private Calendar devolucao;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Bibliotecario bibliotecario;

    @ManyToOne
    Livro livro;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Calendar getRetirada() {
        return retirada;
    }

    public void setRetirada(Calendar retirada) {
        this.retirada = retirada;
    }

    public Calendar getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public void setPrevisaoDevolucao(Calendar previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    public Calendar getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Calendar devolucao) {
        this.devolucao = devolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
