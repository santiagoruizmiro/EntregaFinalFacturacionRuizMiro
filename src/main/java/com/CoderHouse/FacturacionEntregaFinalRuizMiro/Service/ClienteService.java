package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Cliente;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements iClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public List<Cliente> getClientes() {
        List<Cliente>clientesList=clienteRepository.findAll();
        return clientesList;
    }

    @Override
    @Transactional
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cliente=clienteRepository.getById(id);
        return cliente;
    }
}
