package com.example.crud_jdk23.service;

import com.example.crud_jdk23.Entity.Producto;
import com.example.crud_jdk23.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getProducts() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProduct(int id) {
        return productoRepository.findById(id);
    }

    public void saveOrUpdate (Producto producto) {
        productoRepository.save(producto);
    }

    public void delete(int id) {
        productoRepository.deleteById(id);
    }
}
