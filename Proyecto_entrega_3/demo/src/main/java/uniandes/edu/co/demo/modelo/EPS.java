package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "EPS")
@ToString
public class EPS 
{
    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<String> IPSList;
    private List<String> afiliados;
    private List<String> citas;

    public EPS(String nombre, String direccion, String telefono, List<String> IPSList, List<String> afiliados,
            List<String> citas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.IPSList = IPSList;
        this.afiliados = afiliados;
        this.citas = citas;
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

    public List<String> getIPSList() {
        return IPSList;
    }

    public void setIPSList(List<String> iPSList) {
        IPSList = iPSList;
    }

    public List<String> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<String> afiliados) {
        this.afiliados = afiliados;
    }

    public List<String> getCitas() {
        return citas;
    }

    public void setCitas(List<String> citas) {
        this.citas = citas;
    }
    
    
}
