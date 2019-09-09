package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Calendar retirada;
    private Calendar previsaoDevolucao;
    private Calendar devolucao;

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

}
