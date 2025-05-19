package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.EPS;

public interface EPSRepository extends MongoRepository<EPS,Integer>
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
    List<EPS> buscarEPSPorId(int id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{nombre:?1,direccion:?2,telefono:?3,IPSList:?4,afiliados:?5,citas:?6}}")
    void actuaizarEPS(int id, String nombre, String direccion, String telefono, List<Integer> IPSList, List<Integer> afiliados, List<Integer> citas);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarEPS(int id);
}
