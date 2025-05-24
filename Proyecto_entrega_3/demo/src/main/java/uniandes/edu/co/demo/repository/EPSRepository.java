package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.EPS;

public interface EPSRepository extends MongoRepository<EPS,String>
{
    //CREATE
    default void insertarEPS(EPS eps)
    {
        save(eps);
    }

    //READ
    @Query(value="{}")
    List<EPS> buscarTodasEPS();

    @Query("{_id:?0}")
    List<EPS> buscarEPSPorId(String id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{nombre:?1,direccion:?2,telefono:?3,IPSList:?4,afiliados:?5,citas:?6}}")
    void actuaizarEPS(String id, String nombre, String direccion, String telefono, List<String> IPSList, List<String> afiliados, List<String> citas);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarEPS(String id);
}
