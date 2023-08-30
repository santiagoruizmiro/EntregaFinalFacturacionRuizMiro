package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComprobanteRequest {
    private ClienteRequest cliente;
    private List<DetalleVentaRequest> detalles;

    public ComprobanteRequest(ClienteRequest cliente, List<DetalleVentaRequest> detalles) {
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public ClienteRequest getCliente() {
        return cliente;
    }

    public ComprobanteRequest() {
    }

    public void setCliente(ClienteRequest cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVentaRequest> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVentaRequest> detalles) {
        this.detalles = detalles;
    }
}
