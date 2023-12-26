package dev.mkaue.LeedsDeClientesLojasTal.service;

import dev.mkaue.LeedsDeClientesLojasTal.model.Endereco;
import dev.mkaue.LeedsDeClientesLojasTal.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> getEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
