package br.com.grupo3.exc2.repository;


import br.com.grupo3.exc2.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
}
