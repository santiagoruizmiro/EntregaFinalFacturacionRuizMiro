package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Cliente;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Venta;

import java.util.List;

public interface iComprobanteVentaService {
        public List<Venta> getVentas();
        public void saveVenta (Venta venta);
        public void deleteCliente(Long id);
        public Cliente findCliente(Long id);
    }
