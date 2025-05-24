package uniandes.edu.co.demo.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="Cita")
@ToString
public class Cita 
{
    @Id
    private String id;
    private Date fecha;
    private String hora;
    private Servicio servicio;
    private boolean agendada;
    private Afiliado afiliado;
    private int medico;
    private int ips;
    private int ordenAsociada;


    public Cita(Date fecha, String hora, Servicio servicio, boolean agendada, Afiliado afiliado, int medico, int ips,
            int ordenAsociada) {
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.agendada = agendada;
        this.afiliado = afiliado;
        this.medico = medico;
        this.ips = ips;
        this.ordenAsociada = ordenAsociada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public boolean isAgendada() {
        return agendada;
    }

    public void setAgendada(boolean agendada) {
        this.agendada = agendada;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public int getMedico() {
        return medico;
    }

    public void setMedico(int medico) {
        this.medico = medico;
    }

    public int getIps() {
        return ips;
    }

    public void setIps(int ips) {
        this.ips = ips;
    }

    public int getOrdenAsociada() {
        return ordenAsociada;
    }

    public void setOrdenAsociada(int ordenAsociada) {
        this.ordenAsociada = ordenAsociada;
    }

    
}
