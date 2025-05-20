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

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.repository.AfiliadoRepository;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController 
{
    @Autowired
    AfiliadoRepository afiliadoRepository;

    //CREATE
    @PostMapping("/new/save")
    public ResponseEntity<String> crearAfiliado(@RequestBody Afiliado afiliado)
    {
        try{
            afiliadoRepository.save(afiliado);
            return new ResponseEntity<>("Afiliado creado exitosamente",HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear el afiliado: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //READ

    //Obtener todos los afiliados
    @GetMapping("")
    public ResponseEntity<List<Afiliado>> obtenerTodosLosAfiliados()
    {
        try{
            List<Afiliado> afiliados = afiliadoRepository.buscarTodosAfiliados();
            return ResponseEntity.ok(afiliados);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Obtener un afiliado por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Afiliado>> obtenerAfiliadoPorId(@PathVariable("id") int id)
    {
        try{
            List<Afiliado> afiliados = afiliadoRepository.buscarAfiliadoPorId(id);
            if(afiliados != null && !afiliados.isEmpty())
            {
                return ResponseEntity.ok(afiliados);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //UPDATE
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarAfiliado(@PathVariable("id") int id,@RequestBody Afiliado afiliado)
    {
        try{
            afiliadoRepository.actualizarAfiliado(id,
            afiliado.getNombre(), 
            afiliado.getFechaNacimiento(),
            afiliado.getIdentificacion(),
            afiliado.getDireccion(),
            afiliado.getTelefono(),
            afiliado.getTipoAfiliado(),
            afiliado.getContribuyente(),
            afiliado.getParentesco());

            return new ResponseEntity<>("Afiliado actualizado exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el afiliado: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarAfiliado(@PathVariable("id") int id)
    {
        try{
            afiliadoRepository.eliminarAfiliado(id);
            return new ResponseEntity<>("afiliado eliminado exitosamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar el afiliado: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
