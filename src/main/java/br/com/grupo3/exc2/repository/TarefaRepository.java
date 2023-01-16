package br.com.grupo3.exc2.repository;


import br.com.grupo3.exc2.model.Tarefa;
import br.com.grupo3.exc2.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    List<Tarefa> findByUsuarioResponsavel(Usuario usuario);
}
