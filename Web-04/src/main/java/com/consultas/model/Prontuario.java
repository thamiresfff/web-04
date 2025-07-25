package com.consultas.model;

import java.time.LocalDateTime;

/**
 * Classe que representa um prontuário médico no sistema.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class Prontuario {
    private int id;
    private int consultaId;
    private String sintomas;
    private String diagnostico;
    private String tratamento;
    private String observacoes;
    private LocalDateTime dataCadastro;

    public Prontuario() {}

    public Prontuario(int consultaId, String sintomas, String diagnostico, String tratamento, String observacoes) {
        this.consultaId = consultaId;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.observacoes = observacoes;
        this.dataCadastro = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(int consultaId) {
        this.consultaId = consultaId;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
