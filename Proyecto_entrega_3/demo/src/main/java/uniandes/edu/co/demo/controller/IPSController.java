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

import uniandes.edu.co.demo.modelo.IPS;
import uniandes.edu.co.demo.repository.IPSRepository;

@RestController
@RequestMapping("/ips")
public class IPSController 
{
    @Autowired
    IPSRepository ipsRepository;

    //CREATE
    @PostMapping("new/save")
    public ResponseEntity<String> crearIPS(@RequestBody IPS ips)
    {
        try{
            ipsRepository.save(ips);
            return new ResponseEntity<>("IPS creada exitosamente",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear la IPS: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todas las IPS
    @GetMapping("")
    public ResponseEntity<List<IPS>> obtenerTodasLasIPS()
    {
        try{
            List<IPS> ipsList = ipsRepository.buscarTodasIPS();
            return ResponseEntity.ok(ipsList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener una IPS por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<IPS>> obtenerIPSPorId(@PathVariable("id") int id)
    {
        try{
            List<IPS> ipsList = ipsRepository.buscarIPSPorId(id);
            if(ipsList != null && !ipsList.isEmpty())
            {
                return ResponseEntity.ok(ipsList);
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
    public ResponseEntity<String> actualizarIPS(@PathVariable("id") int id, @RequestBody IPS ips)
    {
        try{
            ipsRepository.actualizarIPS(id,
            ips.getNombre(),
            ips.getDireccion(),
            ips.getTelefono(),
            ips.getNIT(),
            ips.getServicios(),
            ips.getMedicos(),
            ips.getOrdenesServ());
            return new ResponseEntity<>("IPS actualizada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar la IPS: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarIPS(@PathVariable("id") int id)
    {
        try{
            ipsRepository.eliminarIPS(id);
            return new ResponseEntity<>("IPS eliminada exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar la IPS: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
