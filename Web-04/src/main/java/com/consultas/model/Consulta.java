package com.consultas.model;

import java.time.LocalDateTime;

/**
 * Classe que representa uma consulta médica no sistema.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class Consulta {
    private int id;
    private int medicoId;
    private int pacienteId;
    private LocalDateTime dataHora;
    private String observacoes;
    private boolean realizada;
    private LocalDateTime dataCadastro;
    
    private Medico medico;
    private Paciente paciente;

    public Consulta() {}

    public Consulta(int medicoId, int pacienteId, LocalDateTime dataHora, String observacoes) {
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
        this.realizada = false;
        this.dataCadastro = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
