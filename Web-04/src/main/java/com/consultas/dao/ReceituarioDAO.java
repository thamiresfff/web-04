package com.consultas.dao;

import com.consultas.config.DatabaseConnection;
import com.consultas.model.Receituario;

import java.sql.*;

/**
 * Classe responsável pelo acesso aos dados de receituários.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class ReceituarioDAO {

    public boolean inserir(Receituario receituario) {
        String sql = "INSERT INTO receituarios (consulta_id, medicamentos, dosagem, instrucoes, data_cadastro) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, receituario.getConsultaId());
            stmt.setString(2, receituario.getMedicamentos());
            stmt.setString(3, receituario.getDosagem());
            stmt.setString(4, receituario.getInstrucoes());
            stmt.setTimestamp(5, Timestamp.valueOf(receituario.getDataCadastro()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Receituario buscarPorConsulta(int consultaId) {
        String sql = "SELECT * FROM receituarios WHERE consulta_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, consultaId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearReceituario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Receituario mapearReceituario(ResultSet rs) throws SQLException {
        Receituario receituario = new Receituario();
        receituario.setId(rs.getInt("id"));
        receituario.setConsultaId(rs.getInt("consulta_id"));
        receituario.setMedicamentos(rs.getString("medicamentos"));
        receituario.setDosagem(rs.getString("dosagem"));
        receituario.setInstrucoes(rs.getString("instrucoes"));
        receituario.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
        return receituario;
    }
}
