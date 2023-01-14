package br.com.grupo3.exc2.controller;

import br.com.grupo3.exc2.dto.TarefaDTO;
import br.com.grupo3.exc2.model.Tarefa;
import br.com.grupo3.exc2.service.TarefaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }

    @GetMapping("/{id}")
    public Tarefa buscaPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.atualizar(tarefaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        tarefaService.deleteById(id);
    }


}
