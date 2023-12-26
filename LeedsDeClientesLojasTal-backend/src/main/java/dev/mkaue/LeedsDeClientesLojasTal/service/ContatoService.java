package dev.mkaue.LeedsDeClientesLojasTal.service;

import dev.mkaue.LeedsDeClientesLojasTal.model.Contato;
import dev.mkaue.LeedsDeClientesLojasTal.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> getContatoById(Long id) {
        return contatoRepository.findById(id);
    }

    public Contato saveContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deleteContato(Long id) {
        contatoRepository.deleteById(id);
    }
}
