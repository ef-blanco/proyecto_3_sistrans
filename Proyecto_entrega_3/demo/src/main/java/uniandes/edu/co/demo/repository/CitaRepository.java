package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.Cita;
import uniandes.edu.co.demo.modelo.Servicio;

public interface CitaRepository extends MongoRepository<Cita,Integer>
{
    //CREATE
    default void insertarCita(Cita cita)
    {
        save(cita);
    }

    //READ
    @Query(value = "{}")
    List<Cita> buscarTodasCitas();

    @Query("{_id:?0}")
    List<Cita> buscarCitaPorId(int id);

    //UPDATE
    @Query("{_id:?0}")
    @Update("{$set:{fecha:?1,hora:?2,servicio:?3,agendada:?4,afiliado:?5,medico:?6,ips:?7,ordenAsociada:?8}}")
    void actualizarCita(int id, String fecha, String hora, Servicio servicio, boolean agendada, Afiliado afiliado, int medico, int ips, int ordenAsociada);

    //DELETE
    @Query(value = "{_id:?0}", delete = true)
    void eliminarCita(int id);
}
