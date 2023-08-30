package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Controller;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.ComprobanteRequest;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Venta;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service.ComprobanteVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ComprobanteVentaController {
    @Autowired
    private ComprobanteVentaService comprobanteVentaService;

    @PostMapping("/{ventaId}/agregarProducto/{productoId}")
    public ResponseEntity<Object> agregarProductoAVenta(
            @PathVariable Long ventaId,
            @PathVariable Long productoId,
            @RequestBody Map<String, Integer> requestBody
    ) {
        int cantidadVendida = requestBody.get("cantidadVendida");
        comprobanteVentaService.agregarProductoAVenta(ventaId, productoId, cantidadVendida);
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Producto agregado a la orden");
        response.put("productoAgregado", productoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/generarComprobante")
    public ResponseEntity<Object> generarComprobantes(
            @RequestBody List<ComprobanteRequest> comprobantes
    ) {
        List<Venta> ventasGeneradas = comprobanteVentaService.generarComprobantes(comprobantes);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Comprobante generado exitosamente");
        response.put("ventas", ventasGeneradas);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}





