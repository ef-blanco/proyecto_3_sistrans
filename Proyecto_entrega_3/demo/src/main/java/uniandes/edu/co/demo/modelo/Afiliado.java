package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "Afiliado")
@ToString
public class Afiliado 
{
    @Id
    private int id;
    private String nombre;
    private String fechaNacimiento;
    private Identificacion identificacion;
    private String direccion;
    private String telefono;
    private String tipoAfiliado;
    private int contribuyente; //TODO: Revisar su implementación
    private String parentesco; //TODO: Revisar su implementación

    public Afiliado(int id, String nombre, String fechaNacimiento, Identificacion identificacion, String direccion,
            String telefono, String tipoAfiliado, int contribuyente, String parentesco) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
        this.contribuyente = contribuyente;
        this.parentesco = parentesco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
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

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public int getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(int contribuyente) {
        this.contribuyente = contribuyente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    
}
