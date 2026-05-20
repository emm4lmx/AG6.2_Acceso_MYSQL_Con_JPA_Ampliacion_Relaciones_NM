package com.AG62.controlador;

import com.AG62.modelo.Coche;
import com.AG62.servicio.CocheServicio;
import com.AG62.servicio.CocheServicioImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
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
        /*
        Tres opciones de realizar la misma operacion. Comprobando que el coche exista:

        return coche.map(c -> ResponseEntity.ok(c)).orElse(ResponseEntity.notFound().build();
        return coche.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build();
        return (coche.isPresent()) ? ResponseEntity.ok(coche.get()) : ResponseEntity.notFound().build();
         */
        return (coche.isPresent()) ? ResponseEntity.ok(coche.get()) : ResponseEntity.notFound().build(); //.build() para construir la respuesta con todo
    }

    // GET /api/coches/disponibles -> solo disponibles (200)
    @GetMapping("disponibles")
    public ResponseEntity<List<Coche>> obtenerDisponibles() {
        return ResponseEntity.ok(cocheServicio.obtenerDisponibles());
    }

    // GET /api/coches/marca/{marca} -> filtrar por marca (200)
    @GetMapping("marca/{marca}")
    public ResponseEntity<List<Coche>> buscarPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(cocheServicio.buscarPorMarca(marca));
    }

    //GET /api/coches/precio?minX&max=Y -> filtrar por rango de precio
    @GetMapping("precio")
    public ResponseEntity<List<Coche>> buscarPorPrecio (@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return ResponseEntity.ok(cocheServicio.buscarPorRangoPrecio(min, max));
    }

    // POST /api/coches -> crea un nuevo coche
    @PostMapping
    public ResponseEntity<Coche> crear(@RequestBody Coche coche){
        Coche nuevo = new Coche();
        //hay que construir la URI del recurso recien creado para la cabezera Location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nuevo.getId()).toUri();
        return ResponseEntity.created(location).body(nuevo); // 201 Created + coche en el body
    }

    // PUT /api/coches/{id} -> actualiza un coche (200 / 404)
    @PutMapping("{id}")
    public ResponseEntity<Coche> actualizar(@PathVariable int id, @RequestBody Coche coche) {
        Optional<Coche> actualizado = cocheServicio.actualizar(id, coche);
        return actualizado.map(ResponseEntity::ok) //si existe -> 200 + coche actualizado
                .orElse(ResponseEntity.notFound().build()); //si no existe -> 404
    }

    // DELETE /api/coches/{id} -> elimina un coche (204 / 404)
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        boolean eliminado = cocheServicio.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() //204 si se borra
                : ResponseEntity.notFound().build(); //404 si no existe
    }









}
