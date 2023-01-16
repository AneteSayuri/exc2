package br.com.grupo3.exc2.service;

import br.com.grupo3.exc2.dto.UsuarioDTO;
import br.com.grupo3.exc2.model.Usuario;
import br.com.grupo3.exc2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Usuario atualizar(UsuarioDTO usuarioDTO, Long id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (!user.isPresent()){
            throw new IllegalArgumentException("Usuario não encontrado.");
        }
        Usuario usuarioParaAtualizar = user.get();
        usuarioParaAtualizar.setEmail(usuarioDTO.getEmail());
        usuarioParaAtualizar.setSenha(usuarioDTO.getSenha());
        return usuarioRepository.save(usuarioParaAtualizar);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
