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

import uniandes.edu.co.demo.modelo.Cita;
import uniandes.edu.co.demo.repository.CitaRepository;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    CitaRepository citaRepository;

    //CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearCita(@RequestBody Cita cita)
    {
        try{
            citaRepository.save(cita);
            return new ResponseEntity<>("Cita creada exitosamente",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear la cita: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todas las citas
    @GetMapping("")
    public ResponseEntity<List<Cita>> obtenerTodasLasCitas()
    {
        try{
            List<Cita> citas = citaRepository.buscarTodasCitas();
            return ResponseEntity.ok(citas);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener un cita por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Cita>> obtenerCitaPorId(@PathVariable("id") String id)
    {
        try{
            List<Cita> citas = citaRepository.buscarCitaPorId(id);
            if(citas != null && !citas.isEmpty())
            {
                return ResponseEntity.ok(citas);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //UPDATE
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarCita(@PathVariable("id") String id, @RequestBody Cita cita)
    {
        try{
            citaRepository.actualizarCita(id,
            cita.getFecha(),
            cita.getServicio(),
            cita.isAgendada(),
            cita.getAfiliado(),
            cita.getMedico(),
            cita.getIps(),
            cita.getOrdenAsociada());

            return new ResponseEntity<>("Cita actualizada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actulizar la cita: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarCita(@PathVariable("id") String id)
    {
        try{
            citaRepository.eliminarCita(id);
            return new ResponseEntity<>("cita eliminada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar la cita: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
