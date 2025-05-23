package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "Medico")
@ToString
public class Medico 
{
    @Id
    private String id;
    private String nombre;
    private Identificacion identificacion;
    private String especialidad;
    private String registroMedico;
    private List<Integer> servicios;
    
    public Medico(String nombre, Identificacion identificacion, String especialidad, String registro,
            List<Integer> servicios) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.especialidad = especialidad;
        this.registroMedico = registro;
        this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getRegistro() {
        return registroMedico;
    }

    public void setRegistro(String registroMedico) {
        this.registroMedico = registroMedico;
    }

    public List<Integer> getServicios() {
        return servicios;
    }

    public void setServicios(List<Integer> servicios) {
        this.servicios = servicios;
    }

    
}
