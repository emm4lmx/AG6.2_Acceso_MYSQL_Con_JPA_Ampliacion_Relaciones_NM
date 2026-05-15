package com.AG62.servicio;

import com.AG62.modelo.Coche;
import com.AG62.repositorio.CocheRepositorio;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CocheServicioImpl implements CocheServicio {
    private final CocheRepositorio cocheRepositorio;

    //constructor
    public CocheServicioImpl(CocheRepositorio cocheRepositorio) {
        this.cocheRepositorio = cocheRepositorio;
    }


    @Override
    public List<Coche> obtenerTodos() {
        return cocheRepositorio.findAll();
    }
//cuando quieres devolver Coche es mejor devolver Optional para evitar controlar excepciones
    @Override
    public Optional<Coche> obtenerPorId(int id) { //devuelve Optional porq no tiene por que existir un coche con ese id
        return cocheRepositorio.findById(id); //devuelve coche o Optional vacio
    }

    @Override
    public List<Coche> buscarPorMarca(String marca) {
        return cocheRepositorio.findByMarcaIgnoreCase(marca);
    }

    @Override
    public List<Coche> obtenerDisponibles() {
        return cocheRepositorio.findByDisponibleTrue();
    }

    @Override
    public List<Coche> buscarPorRangoPrecio(BigDecimal min, BigDecimal max) {
        return cocheRepositorio.findByPrecioBetween(min, max);
    }

    @Override
    public List<Coche> obtenerDesdeAnio(int anio) {
        return cocheRepositorio.findCochesDesdeAnio(anio);
    }

    @Override
    public Coche guardar(Coche coche) {
        return null;
    }

    @Override
    public Optional<Coche> actualizar(Coche coche) {
        Optional<Coche> cocheOptional = cocheRepositorio.findById(coche.getId()); //devuelve Optional (si esta vacio --> empty)
        if (cocheOptional.isEmpty()) return Optional.empty();
        return Optional.of(cocheRepositorio.save(coche));
    }

    @Override
    public boolean eliminar(int id) {
        Optional<Coche> cocheOptional = cocheRepositorio.findById(id);
        cocheRepositorio.deleteById(id);
        return cocheOptional.isPresent(); //devuelve true/false
        /*
        if (cocheOptional.isPresent()) { //compruebo si está
            return true;
        */
    }
}
