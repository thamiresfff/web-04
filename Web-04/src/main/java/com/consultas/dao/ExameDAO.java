package com.consultas.dao;

import com.consultas.config.DatabaseConnection;
import com.consultas.model.Exame;

import java.sql.*;

/**
 * Classe responsável pelo acesso aos dados de exames.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class ExameDAO {

    public boolean inserir(Exame exame) {
        String sql = "INSERT INTO exames (consulta_id, tipo_exame, descricao, resultado, data_exame, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, exame.getConsultaId());
            stmt.setString(2, exame.getTipoExame());
            stmt.setString(3, exame.getDescricao());
            stmt.setString(4, exame.getResultado());
            stmt.setTimestamp(5, Timestamp.valueOf(exame.getDataExame()));
            stmt.setTimestamp(6, Timestamp.valueOf(exame.getDataCadastro()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Exame buscarPorConsulta(int consultaId) {
        String sql = "SELECT * FROM exames WHERE consulta_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, consultaId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearExame(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Exame mapearExame(ResultSet rs) throws SQLException {
        Exame exame = new Exame();
        exame.setId(rs.getInt("id"));
        exame.setConsultaId(rs.getInt("consulta_id"));
        exame.setTipoExame(rs.getString("tipo_exame"));
        exame.setDescricao(rs.getString("descricao"));
        exame.setResultado(rs.getString("resultado"));
        exame.setDataExame(rs.getTimestamp("data_exame").toLocalDateTime());
        exame.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
        return exame;
    }
}
