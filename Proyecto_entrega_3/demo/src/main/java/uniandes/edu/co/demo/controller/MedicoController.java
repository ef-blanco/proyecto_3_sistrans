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

import uniandes.edu.co.demo.modelo.Medico;
import uniandes.edu.co.demo.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController 
{
    @Autowired
    MedicoRepository medicoRepository;

    //CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearMedico(@RequestBody Medico medico)
    {
        try{
            medicoRepository.save(medico);
            return new ResponseEntity<>("Medico creado exitosamente",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear el medico: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todos los medicos
    @GetMapping("")
    public ResponseEntity<List<Medico>> obtenerTodosLosMedicos()
    {
        try{
            List<Medico> medicos = medicoRepository.buscarTodosMedico();
            return ResponseEntity.ok(medicos);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener un medico por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Medico>> obtenerMedicoPorId(@PathVariable("id") int id)
    {
        try{
            List<Medico> medicos = medicoRepository.buscarMedicoPorId(id);
            if(medicos != null && !medicos.isEmpty())
            {
                return ResponseEntity.ok(medicos);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //UPDATE
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarMedico(@PathVariable("id") int id, @RequestBody Medico medico)
    {
        try{
            medicoRepository.actualizarMedico(id,
             medico.getNombre(),
             medico.getIdentificacion(),
             medico.getEspecialidad(),
             medico.getRegistro(),
             medico.getServicios());
             return new ResponseEntity<>("Medico actualizado exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el medico: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarMedico(@PathVariable("id") int id)
    {
        try{
            medicoRepository.eliminarMedico(id);
            return new ResponseEntity<>("medico eliminado exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar el medico: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
