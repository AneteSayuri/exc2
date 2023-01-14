package br.com.grupo3.exc2.controller;

import br.com.grupo3.exc2.dto.UsuarioDTO;
import br.com.grupo3.exc2.model.Usuario;
import br.com.grupo3.exc2.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscaPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.atualizar(usuarioDTO, id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }


}
