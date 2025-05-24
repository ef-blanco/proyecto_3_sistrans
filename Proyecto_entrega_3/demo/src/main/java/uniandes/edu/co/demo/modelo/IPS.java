package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="IPS")
@ToString
public class IPS 
{
    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;
    private List<String> servicios;
    private List<String> medicos;
    private List<String> ordenesServ;
    
    public IPS(String nombre, String direccion, String telefono, String NIT, List<String> servicios,
            List<String> medicos, List<String> ordenesServ) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
        this.servicios = servicios;
        this.medicos = medicos;
        this.ordenesServ = ordenesServ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return this.NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }

    public List<String> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<String> medicos) {
        this.medicos = medicos;
    }

    public List<String> getOrdenesServ() {
        return ordenesServ;
    }

    public void setOrdenesServ(List<String> ordenesServ) {
        this.ordenesServ = ordenesServ;
    }

    
}
