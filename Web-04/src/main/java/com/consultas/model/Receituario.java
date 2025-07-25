package com.consultas.model;

import java.time.LocalDateTime;

/**
 * Classe que representa um receituário médico no sistema.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class Receituario {
    private int id;
    private int consultaId;
    private String medicamentos;
    private String dosagem;
    private String instrucoes;
    private LocalDateTime dataCadastro;

    public Receituario() {}

    public Receituario(int consultaId, String medicamentos, String dosagem, String instrucoes) {
        this.consultaId = consultaId;
        this.medicamentos = medicamentos;
        this.dosagem = dosagem;
        this.instrucoes = instrucoes;
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

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
