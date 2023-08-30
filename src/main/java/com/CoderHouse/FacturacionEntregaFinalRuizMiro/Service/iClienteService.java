package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface iClienteService {
    public List<Cliente> getClientes();
    public void saveCliente (Cliente cliente);
    public void deleteCliente(Long id);
    public Cliente findCliente(Long id);
}
