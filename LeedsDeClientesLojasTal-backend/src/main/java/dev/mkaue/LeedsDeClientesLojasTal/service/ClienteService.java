package dev.mkaue.LeedsDeClientesLojasTal.service;

import dev.mkaue.LeedsDeClientesLojasTal.model.Cliente;
import dev.mkaue.LeedsDeClientesLojasTal.model.Contato;
import dev.mkaue.LeedsDeClientesLojasTal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente addContatoToCliente(Long clienteId, Contato contato) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            contato.setCliente(cliente);
            cliente.getContatos().add(contato);
            return clienteRepository.save(cliente);
        }

        throw new RuntimeException("Cliente não encontrado com o ID: " + clienteId);

    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
