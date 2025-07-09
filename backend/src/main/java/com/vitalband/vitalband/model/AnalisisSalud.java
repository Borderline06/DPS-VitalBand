package com.vitalband.vitalband.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "analisis_salud")
public class AnalisisSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    private LocalDateTime fecha;
    private int frecuenciaCardiaca;
    private int saturacionOxigeno;
    private int pasos;
    private int calorias;
    private String estado;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public int getFrecuenciaCardiaca() { return frecuenciaCardiaca; }
    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) { this.frecuenciaCardiaca = frecuenciaCardiaca; }

    public int getSaturacionOxigeno() { return saturacionOxigeno; }
    public void setSaturacionOxigeno(int saturacionOxigeno) { this.saturacionOxigeno = saturacionOxigeno; }

    public int getPasos() { return pasos; }
    public void setPasos(int pasos) { this.pasos = pasos; }

    public int getCalorias() { return calorias; }
    public void setCalorias(int calorias) { this.calorias = calorias; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
