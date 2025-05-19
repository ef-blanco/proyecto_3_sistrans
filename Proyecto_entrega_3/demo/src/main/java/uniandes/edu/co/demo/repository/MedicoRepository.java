package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Identificacion;
import uniandes.edu.co.demo.modelo.Medico;

public interface MedicoRepository extends MongoRepository<Medico,Integer>
{
    //CREATE
    default void insertarMedico(Medico medico)
    {
        save(medico);
    }

    //READ
    @Query(value = "{}")
    List<Medico> buscarTodosMedico();

    @Query("{_id:?0}")
    List<Medico> buscarMedicoPorId(int id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{nombre:?1,identificacion:?2,especialidad:?3,registroMedico:?4,servicios:?5}}")
    void actualizarMedico(int id,String nombre,Identificacion identificacion,String especialidad, String registroMedico, List<Integer> servicios);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarMedico(int id);
}
