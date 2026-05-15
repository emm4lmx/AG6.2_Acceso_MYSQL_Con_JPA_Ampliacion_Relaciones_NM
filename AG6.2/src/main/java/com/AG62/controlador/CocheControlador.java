package com.AG62.controlador;

import com.AG62.modelo.Coche;
import com.AG62.servicio.CocheServicio;
import com.AG62.servicio.CocheServicioImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//recibe peticiones y las manda fuera
@RestController
@RequestMapping("/api/coches")
public class CocheControlador {
    private final CocheServicio cocheServicio;

    public CocheControlador(CocheServicio cocheServicio){
        this.cocheServicio = cocheServicio;
    }

    @GetMapping
    public ResponseEntity<List<Coche>> obtenerTodos() {
        List<Coche> coches = cocheServicio.obtenerTodos();
        return ResponseEntity.ok(coches); //200 OK + lista (vacia "[]" si no hay datos)
    }

    @GetMapping("buscarPorID/{id}")
    public ResponseEntity<Coche> obtenerPorId(@PathVariable int id) {
        Optional<Coche> coche = cocheServicio.obtenerPorId(id);
        return (coche.isPresent()) ? ResponseEntity.ok(coche.get()) : ResponseEntity.notFound();
    }
}
