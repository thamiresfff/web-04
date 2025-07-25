package com.consultas.model;

import java.time.LocalDateTime;

/**
 * Classe que representa um exame médico no sistema.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class Exame {
    private int id;
    private int consultaId;
    private String tipoExame;
    private String descricao;
    private String resultado;
    private LocalDateTime dataExame;
    private LocalDateTime dataCadastro;

    public Exame() {}

    public Exame(int consultaId, String tipoExame, String descricao, String resultado, LocalDateTime dataExame) {
        this.consultaId = consultaId;
        this.tipoExame = tipoExame;
        this.descricao = descricao;
        this.resultado = resultado;
        this.dataExame = dataExame;
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

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDateTime dataExame) {
        this.dataExame = dataExame;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
