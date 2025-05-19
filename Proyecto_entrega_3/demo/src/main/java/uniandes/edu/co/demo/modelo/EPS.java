package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "EPS")
@ToString
public class EPS 
{
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Integer> IPSList;
    private List<Integer> afiliados;
    private List<Integer> citas;

    public EPS(String nombre, String direccion, String telefono, List<Integer> iPSList, List<Integer> afiliados,
            List<Integer> citas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        IPSList = iPSList;
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

    public List<Integer> getIPSList() {
        return IPSList;
    }

    public void setIPSList(List<Integer> iPSList) {
        IPSList = iPSList;
    }

    public List<Integer> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Integer> afiliados) {
        this.afiliados = afiliados;
    }

    public List<Integer> getCitas() {
        return citas;
    }

    public void setCitas(List<Integer> citas) {
        this.citas = citas;
    }
    
    
}
