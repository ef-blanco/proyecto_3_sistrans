package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.Identificacion;

public interface AfiliadoRepository extends MongoRepository<Afiliado,Integer>
{
    //CREATE
    default void insertarAfiliado(Afiliado afiliado)
    {
        save(afiliado);
    }
    
    //READ
    @Query(value = "{}", fields = "")
    List<Afiliado> buscarTodosAfiliados();

    @Query("{_id:?0}")
    List<Afiliado> buscarAfiliadoPorId(int id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{nombre:?1,fechaNacimiento:?2,identificacion:?3,direccion:?4,telefono:?5,tipoAfiliado:?6,contribuyente:?7,parentesco:?8}}")
    void actualizarAfiliado(int id, String nombre, String fechaNacimiento, Identificacion identificacion, String direccion, String telefono, String tipoAfiliado, int contribuyente, String parentesco);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarAfiliado(int id);

}
