package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    // Método para buscar productos por descripción que contiene texto, ignorando mayúsculas y minúsculas
    public List<Producto> findByDescripcionContainingIgnoreCase(String texto);

    // Método para buscar productos por precio en un rango dado y ordenados por descripción
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    // Consulta JPQL para buscar productos por precio en un rango dado y ordenados por descripción
    @Query(value="SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    // Consulta SQL nativa para buscar productos por precio en un rango dado y ordenados por descripción
    @Query(nativeQuery=true, value="SELECT * FROM producto WHERE producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
