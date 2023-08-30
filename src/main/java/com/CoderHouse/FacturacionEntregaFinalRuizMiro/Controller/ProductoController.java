package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Controller;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Producto;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.ProductoRepository;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Component
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    private ProductoRepository productoRepository;
    @GetMapping("/productos")
    @ResponseBody
    public List<Producto> getProductos() {
        List<Producto> productosList = productoService.getProductos();
        return productosList;
    }

        @Transactional
        @PutMapping("/{id}")
        public ResponseEntity<Producto> modificarPrecio(@PathVariable Long id, @RequestBody Map<String, Double> request) {
            Double nuevoPrecio = request.get("precio");

            if (nuevoPrecio == null || nuevoPrecio < 0) {
                return ResponseEntity.badRequest().build();
            }

            Producto producto = productoService.findProducto(id);

            if (producto == null) {
                return ResponseEntity.notFound().build();
            }

            productoService.modificarprecio(id,nuevoPrecio);
            return ResponseEntity.ok(producto);
        }
    }


