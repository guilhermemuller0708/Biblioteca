package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany
    private List<Usuario> usuario;

    public int getId() {
        return id;
    }

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

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

}
