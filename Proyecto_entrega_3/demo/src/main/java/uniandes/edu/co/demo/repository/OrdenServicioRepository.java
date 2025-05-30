package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.modelo.Servicio;

public interface OrdenServicioRepository extends MongoRepository<OrdenServicio,String>
{
    //CREATE
    default void insertarOrdenServicio(OrdenServicio ordenServicio)
    {
        save(ordenServicio);
    }

    //READ
    @Query(value="{}")
    List<OrdenServicio> buscarTodasOrdenServicio();

    @Query("{_id:?0}")
    List<OrdenServicio> buscarOrdenServicioPorId(String id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{estado:?1,fecha:?2,afiliado:?3,servicio:?4,medico:?5}}")
    void actualizarOrdenServicio(String id,String estado,String fecha,Afiliado afiliado,Servicio servicio, String medico);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarOrdenServicio(String id);
}
