package uniandes.edu.co.demo.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="OrdenServicio")
@ToString
public class OrdenServicio 
{
    private String estado;
    private String fecha;
    private Afiliado afiliado;
    private Servicio servicio;
    private int medico;
    
    public OrdenServicio(String estado, String fecha, Afiliado afiliado, Servicio servicio, int medico) {
        this.estado = estado;
        this.fecha = fecha;
        this.afiliado = afiliado;
        this.servicio = servicio;
        this.medico = medico;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Afiliado getAfiliado() {
        return afiliado;
    }
    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public int getMedico() {
        return medico;
    }
    public void setMedico(int medico) {
        this.medico = medico;
    }

    
}
