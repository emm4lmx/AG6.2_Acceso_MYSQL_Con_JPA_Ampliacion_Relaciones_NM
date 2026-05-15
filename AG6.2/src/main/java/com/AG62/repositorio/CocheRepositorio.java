package com.AG62.repositorio;

import com.AG62.modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CocheRepositorio extends JpaRepository<Coche, Integer> {
    // Consultas derivadas (sin SQL, Spring las genera por el nombre del método)
    List<Coche> findByMarcaIgnoreCase(String marca);
    List<Coche> findByDisponibleTrue();
    List<Coche> findByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);

    // Consulta personalizada con JPQL
    @Query("SELECT c FROM Coche c WHERE c.anio >= :anio ORDER BY c.precio ASC")
    List<Coche> findCochesDesdeAnio(@Param("anio") int anio);

}
