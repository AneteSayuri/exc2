package br.com.grupo3.exc2.controller;

import br.com.grupo3.exc2.model.Endereco;
import br.com.grupo3.exc2.model.Tarefa;
import br.com.grupo3.exc2.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public Endereco criar(@RequestBody Endereco endereco) {
        return enderecoService.criar(endereco);
    }

    @GetMapping
    public List<Endereco> listar() {
        return enderecoService.listar();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id){
        return enderecoService.buscarPorId(id);
    }

}
