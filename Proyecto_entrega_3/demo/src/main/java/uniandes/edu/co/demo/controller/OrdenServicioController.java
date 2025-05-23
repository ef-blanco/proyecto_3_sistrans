package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;

@RestController
@RequestMapping("/ordenesServicio")
public class OrdenServicioController 
{
    @Autowired
    OrdenServicioRepository ordenServicioRepository;

    //CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearOrdenServicio(@RequestBody OrdenServicio ordenServicio)
    {
        try{
            ordenServicioRepository.save(ordenServicio);
            return new ResponseEntity<>("OrdenServicio creada exitosamente",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear la ordenServicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todas las OrdenServicio
    @GetMapping("")
    public ResponseEntity<List<OrdenServicio>> obtenerTodasLasOrdenServicio()
    {
        try{
            List<OrdenServicio> ordenes = ordenServicioRepository.buscarTodasOrdenServicio();
            return ResponseEntity.ok(ordenes);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener una OrdenServicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<OrdenServicio>> obtenerOrdenServicioPorId(@PathVariable("id") String id)
    {
        try{
            List<OrdenServicio> ordenes = ordenServicioRepository.buscarOrdenServicioPorId(id);
            if(ordenes != null && !ordenes.isEmpty())
            {
                return ResponseEntity.ok(ordenes);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //UPDATE
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarOrdenServicio(@PathVariable("id") String id,@RequestBody OrdenServicio ordenServicio)
    {
        try{
            ordenServicioRepository.actualizarOrdenServicio(id,
            ordenServicio.getEstado(),
            ordenServicio.getFecha(),
            ordenServicio.getAfiliado(),
            ordenServicio.getServicio(),
            ordenServicio.getMedico());
            return new ResponseEntity<>("OrdenServicio actualizada exitosamente",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la ordenServicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarOrdenServicio(@PathVariable("id") String id)
    {
        try{
            ordenServicioRepository.eliminarOrdenServicio(id);
            return new ResponseEntity<>("OrdenServicio eliminada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar la ordenServicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
