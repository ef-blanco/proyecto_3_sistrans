package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;

@RestController
@RequestMapping("/ordenesServicio")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    // CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearOrdenServicio(@RequestBody OrdenServicio ordenServicio) {
        try {
            ordenServicioRepository.save(ordenServicio);
            return new ResponseEntity<>("OrdenServicio creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la ordenServicio: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ - Obtener todas las órdenes
    @GetMapping("")
    public ResponseEntity<List<OrdenServicio>> obtenerTodasLasOrdenServicio() {
        try {
            List<OrdenServicio> ordenes = ordenServicioRepository.findAll();
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // READ - Obtener orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicio> obtenerOrdenServicioPorId(@PathVariable("id") String id) {
        return ordenServicioRepository.findById(id)
                .map(orden -> ResponseEntity.ok(orden))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // UPDATE - Actualizar orden
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarOrdenServicio(@PathVariable("id") String id,
            @RequestBody OrdenServicio ordenServicio) {
        try{
            ordenServicioRepository.actualizarOrdenServicio(id,
            ordenServicio.getEstado(),
            ordenServicio.getFecha(),
            ordenServicio.getAfiliado(),
            ordenServicio.getServicio(),
            ordenServicio.getMedico());
            return new ResponseEntity<>("Orden de servicio actualizado exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el orden de servicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE - Eliminar orden
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarOrdenServicio(@PathVariable("id") String id) {
        if (!ordenServicioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OrdenServicio no encontrada");
        }
        try {
            ordenServicioRepository.deleteById(id);
            return ResponseEntity.ok("OrdenServicio eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la ordenServicio: " + e.getMessage());
        }
    }
}
