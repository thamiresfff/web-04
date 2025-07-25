package com.consultas.dao;

import com.consultas.config.DatabaseConnection;
import com.consultas.model.Prontuario;

import java.sql.*;

/**
 * Classe responsável pelo acesso aos dados de prontuários.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class ProntuarioDAO {

    public boolean inserir(Prontuario prontuario) {
        String sql = "INSERT INTO prontuarios (consulta_id, sintomas, diagnostico, tratamento, observacoes, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, prontuario.getConsultaId());
            stmt.setString(2, prontuario.getSintomas());
            stmt.setString(3, prontuario.getDiagnostico());
            stmt.setString(4, prontuario.getTratamento());
            stmt.setString(5, prontuario.getObservacoes());
            stmt.setTimestamp(6, Timestamp.valueOf(prontuario.getDataCadastro()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Prontuario buscarPorConsulta(int consultaId) {
        String sql = "SELECT * FROM prontuarios WHERE consulta_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, consultaId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearProntuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Prontuario mapearProntuario(ResultSet rs) throws SQLException {
        Prontuario prontuario = new Prontuario();
        prontuario.setId(rs.getInt("id"));
        prontuario.setConsultaId(rs.getInt("consulta_id"));
        prontuario.setSintomas(rs.getString("sintomas"));
        prontuario.setDiagnostico(rs.getString("diagnostico"));
        prontuario.setTratamento(rs.getString("tratamento"));
        prontuario.setObservacoes(rs.getString("observacoes"));
        prontuario.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
        return prontuario;
    }
}
