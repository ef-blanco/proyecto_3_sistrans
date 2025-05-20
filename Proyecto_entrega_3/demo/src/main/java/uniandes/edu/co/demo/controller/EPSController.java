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

import uniandes.edu.co.demo.modelo.EPS;
import uniandes.edu.co.demo.repository.EPSRepository;

@RestController
@RequestMapping("/eps")
public class EPSController 
{
    @Autowired
    EPSRepository epsRepository;

    //CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearEPS(@RequestBody EPS eps)
    {
        try{
            epsRepository.save(eps);
            return new ResponseEntity<>("EPS creada exitosamente",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear la EPS: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todas las EPS
    @GetMapping("")
    public ResponseEntity<List<EPS>> obtenerTodasLasEPS()
    {
        try{
            List<EPS> epslist = epsRepository.buscarTodasEPS();
            return ResponseEntity.ok(epslist);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener una EPS por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<EPS>> obtenerEPSPorId(@PathVariable("id") int id)
    {
        try{
            List<EPS> epslist = epsRepository.buscarEPSPorId(id);
            if(epslist != null && !epslist.isEmpty())
            {
                return ResponseEntity.ok(epslist);
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
    public ResponseEntity<String> actualizarEPS(@PathVariable("id") int id, @RequestBody EPS eps)
    {
        try{
            epsRepository.actuaizarEPS(id,
            eps.getNombre(),
            eps.getDireccion(),
            eps.getTelefono(),
            eps.getIPSList(),
            eps.getAfiliados(),
            eps.getCitas());
            return new ResponseEntity<>("EPS actualizada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar la EPS: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarEPS(@PathVariable("id") int id)
    {
        try{
            epsRepository.eliminarEPS(id);
            return new ResponseEntity<>("EPS eliminada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar la EPS: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
