package br.com.grupo3.exc2.service;

import br.com.grupo3.exc2.dto.TarefaDTO;
import br.com.grupo3.exc2.model.Tarefa;
import br.com.grupo3.exc2.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Tarefa atualizar(TarefaDTO tarefaDTO, Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (!tarefa.isPresent()){
            throw new IllegalArgumentException("Tarefa não encontrado.");
        }
        Tarefa usuarioParaAtualizar = tarefa.get();
        usuarioParaAtualizar.setPrioridade(tarefaDTO.getPrioridade());
        usuarioParaAtualizar.setStatus(tarefaDTO.getStatus());
        return tarefaRepository.save(usuarioParaAtualizar);
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }
}
