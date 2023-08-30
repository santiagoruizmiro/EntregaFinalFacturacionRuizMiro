package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Cliente;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.DetalleVenta;

import java.util.List;

public interface iDetalleVentaService {
    public List<DetalleVenta> getDetallesVentas();
    public void saveDetalleVenta (DetalleVenta detalleventa);
    public void deleteDetalleVenta(Long id);
    public Cliente findDetalleVenta(Long id);
}
