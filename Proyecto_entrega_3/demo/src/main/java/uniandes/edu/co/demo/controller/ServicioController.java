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

import uniandes.edu.co.demo.modelo.Servicio;
import uniandes.edu.co.demo.repository.ServicioRepository;

@RestController
@RequestMapping("/servicios")
public class ServicioController 
{
    @Autowired
    ServicioRepository servicioRepository;

    //CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearServicio(@RequestBody Servicio servicio)
    {
        try{
            servicioRepository.save(servicio);
            return new ResponseEntity<>("Servicio creado exitosamente",HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Error al crear el servicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todos los servicios
    @GetMapping("")
    public ResponseEntity<List<Servicio>> obtenerTodosLosServicios()
    {
        try{
            List<Servicio> servicios = servicioRepository.buscarTodosServicio();
            return ResponseEntity.ok(servicios);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener un servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Servicio>> obtenerServicioPorId(@PathVariable("id") String id)
    {
        try{
            List<Servicio> servicios = servicioRepository.buscarServicioPorId(id);
            if( servicios != null && !servicios.isEmpty())
            {
                return ResponseEntity.ok(servicios);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //UPDATE
    @PostMapping("{id}/edit/save")
    public ResponseEntity<String> actualizarServicio(@PathVariable("id") String id, @RequestBody Servicio servicio)
    {
        try{
            servicioRepository.actualizarServicio(
                id,
                servicio.getNombre(),
                servicio.getTipo(),
                servicio.getDescripcion());
                return new ResponseEntity<>("Servicio actualizado exitosamente",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error al actualizar el servicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarServicio(@PathVariable("id") String id)
    {
        try{
            servicioRepository.eliminarServicio(id);
            return new ResponseEntity<>("servicio eliminado exitosamente",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error al eliminar el servicio: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
