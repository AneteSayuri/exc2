package br.com.grupo3.exc2.repository;


import br.com.grupo3.exc2.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
