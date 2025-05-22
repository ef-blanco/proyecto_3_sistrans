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
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;
    private List<Integer> servicios;
    private List<Integer> medicos;
    private List<Integer> ordenesServ;
    
    public IPS(String nombre, String direccion, String telefono, String nIT, List<Integer> servicios,
            List<Integer> medicos, List<Integer> ordenesServ) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        NIT = nIT;
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
        return NIT;
    }

    public void setNIT(String nIT) {
        NIT = nIT;
    }

    public List<Integer> getServicios() {
        return servicios;
    }

    public void setServicios(List<Integer> servicios) {
        this.servicios = servicios;
    }

    public List<Integer> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Integer> medicos) {
        this.medicos = medicos;
    }

    public List<Integer> getOrdenesServ() {
        return ordenesServ;
    }

    public void setOrdenesServ(List<Integer> ordenesServ) {
        this.ordenesServ = ordenesServ;
    }

    
}
