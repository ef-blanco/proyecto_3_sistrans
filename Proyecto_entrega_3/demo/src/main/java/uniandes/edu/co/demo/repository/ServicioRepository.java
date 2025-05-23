package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio,String>
{
    //CREATE
    default void insertarServicio(Servicio servicio)
    {
        save(servicio);
    }

    //READ
    @Query(value = "{}")
    List<Servicio> buscarTodosServicio();

    @Query("{_id:?0}")
    List<Servicio> buscarServicioPorId(String id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{nombre:?1,tipo:?2,descripcion:?3}}")
    void actualizarServicio(String id, String nombre, String tipo, String descripcion);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarServicio(String id);
}
