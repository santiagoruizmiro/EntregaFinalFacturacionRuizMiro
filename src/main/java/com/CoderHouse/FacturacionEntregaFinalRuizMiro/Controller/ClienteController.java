package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Controller;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Cliente;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> getClientes() {
        List<Cliente> clientesList = clienteService.getClientes();
        return clientesList;
    }

    @GetMapping("/{id}")
    public Cliente findCliente(@PathVariable long id) {
        Cliente cliente=clienteService.findCliente(id);
        return cliente;
    }
    @PostMapping("/crearcliente")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "El cliente fue creado con exito";
    }

    @DeleteMapping("/eliminarcliente/{id}")
    public String deleteCliente(@PathVariable long id){
        clienteService.deleteCliente(id);
        return "el cliente ha sido eliminado";
    }
}

