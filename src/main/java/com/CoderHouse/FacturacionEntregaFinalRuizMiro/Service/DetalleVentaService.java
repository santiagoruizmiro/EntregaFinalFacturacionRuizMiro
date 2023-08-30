package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Cliente;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.DetalleVenta;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class DetalleVentaService implements iDetalleVentaService {
        private final DetalleVentaRepository detalleventaRepository;

        public DetalleVentaService(DetalleVentaRepository detalleventaRepository) {
            this.detalleventaRepository = detalleventaRepository;
        }

        @Override
        public List<DetalleVenta> getDetallesVentas() {
            return null;
        }

        @Override
        public void saveDetalleVenta(DetalleVenta detalleventa) {

        }

        @Override
        public void deleteDetalleVenta(Long id) {

        }

        @Override
        public Cliente findDetalleVenta(Long id) {
            return null;
        }
    }