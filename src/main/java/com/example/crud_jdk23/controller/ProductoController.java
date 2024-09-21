package com.example.crud_jdk23.controller;

import com.example.crud_jdk23.Entity.Producto;
import com.example.crud_jdk23.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/v1/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAll(){
        return productoService.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Producto> getProduct(@PathVariable("productId") int id){
        return productoService.getProduct(id);
    }

    @PostMapping
    public Producto saveUpdate(@RequestBody Producto producto ){
        productoService.saveOrUpdate(producto);
        return producto;
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") int  productId ){
        productoService.delete(productId);
    }

    @GetMapping("/sumaProductos")
    public double getSumProducts(){
        List<Producto> elements = productoService.getProducts();
        double total = 0;
        int stock = 0;
        double precio = 0;

        for (Producto element : elements) {
            stock = element.getCantidad_en_stock();
            precio = element.getPrecio();
            total += stock * precio;
        }
        return total;
    }



}
