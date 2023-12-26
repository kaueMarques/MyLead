package dev.mkaue.LeedsDeClientesLojasTal.controller;

import dev.mkaue.LeedsDeClientesLojasTal.model.Cliente;
import dev.mkaue.LeedsDeClientesLojasTal.model.Contato;
import dev.mkaue.LeedsDeClientesLojasTal.service.ClienteService;
import dev.mkaue.LeedsDeClientesLojasTal.util.PhoneUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/erro")
    public String forceErro() {
        throw new RuntimeException("Erro simulado ao obter todos os clientes.");
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Salva um novo cliente no sistema.
     *
     * @param cliente
     * @param o parametro de telefone deve ser unico no banco de dados assim e ter de 8-9 digitos
     *
     * @return Irá retornar 201 se comprir os requisitos de 8 à 9 digitos, e também deve não existir no BD
     * <br> caso isso não ocorra retornará 406 -  não aceito
     *
     * @throws Exception não será demonstrada exception do lado do cliente, mas sim no log, suas causas são o não cumprimento das regras de requisicao
     */
    @PostMapping
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente) throws Exception {

        if (PhoneUtil.isTelefoneBrasileiro(cliente.getContatos().get(0).getNumeroTelefone())) {
            Cliente savedCliente = clienteService.saveCliente(cliente);
            return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
        }

        Map<String, String> errorResponse = Collections.singletonMap("msg", "formato de telefone não aceito");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("/{clienteId}/contatos")
    public ResponseEntity<Cliente> addContatoToCliente(@PathVariable Long clienteId, @RequestBody Contato contato) {
        Cliente updatedCliente = clienteService.addContatoToCliente(clienteId, contato);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }
}
