package dev.mkaue.LeedsDeClientesLojasTal.controller;

import dev.mkaue.LeedsDeClientesLojasTal.model.Contato;
import dev.mkaue.LeedsDeClientesLojasTal.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> getAllContatos() {
        List<Contato> contatos = contatoService.getAllContatos();
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        return contatoService.getContatoById(id)
                .map(contato -> new ResponseEntity<>(contato, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Contato> saveContato(@RequestBody Contato contato) {
        Contato savedContato = contatoService.saveContato(contato);
        return new ResponseEntity<>(savedContato, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
        contatoService.deleteContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
