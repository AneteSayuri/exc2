package br.com.grupo3.exc2.service;

import br.com.grupo3.exc2.model.Endereco;
import br.com.grupo3.exc2.model.Tarefa;
import br.com.grupo3.exc2.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco criar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listar(){
        return (List<Endereco>) enderecoRepository.findAll();
    }
    public Endereco buscarPorId(Long id){
        return enderecoRepository.findById(id).orElse(null);
    }


}
