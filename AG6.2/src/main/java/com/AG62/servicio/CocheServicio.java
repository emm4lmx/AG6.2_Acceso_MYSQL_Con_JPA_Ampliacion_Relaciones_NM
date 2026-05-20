package com.AG62.servicio;

import com.AG62.modelo.Coche;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional; //es un envoltorio que evita las excepciones de null, etc

public interface CocheServicio {
    List<Coche> obtenerTodos();
    Optional<Coche> obtenerPorId(int id);
    List<Coche> buscarPorMarca(String marca);
    List<Coche> obtenerDisponibles();
    List<Coche> buscarPorRangoPrecio(BigDecimal min, BigDecimal max);
    List<Coche> obtenerDesdeAnio(int anio);
    Coche guardar(Coche coche);
    Optional<Coche> actualizar(int id, Coche coche);
    boolean eliminar(int id);

}
