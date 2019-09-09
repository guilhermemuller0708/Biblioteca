/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.dao;

import br.edu.restinga.ifrs.gui.biblioteca.biblioteca.modelo.entidade.Editora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraDAO extends CrudRepository<Editora, Integer> {

}
