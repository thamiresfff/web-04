package com.consultas.dao;

import com.consultas.config.DatabaseConnection;
import com.consultas.model.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados de médicos.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class MedicoDAO {

    public boolean inserir(Medico medico) {
        String sql = "INSERT INTO medicos (nome, crm, especialidade, email, senha, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setString(4, medico.getEmail());
            stmt.setString(5, medico.getSenha());
            stmt.setTimestamp(6, Timestamp.valueOf(medico.getDataCadastro()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Medico buscarPorId(int id) {
        String sql = "SELECT * FROM medicos WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearMedico(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Medico buscarPorEmail(String email) {
        String sql = "SELECT * FROM medicos WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearMedico(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Medico> listarTodos() {
        String sql = "SELECT * FROM medicos ORDER BY nome";
        List<Medico> medicos = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                medicos.add(mapearMedico(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    public boolean autenticar(String email, String senha) {
        String sql = "SELECT COUNT(*) FROM medicos WHERE email = ? AND senha = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Medico mapearMedico(ResultSet rs) throws SQLException {
        Medico medico = new Medico();
        medico.setId(rs.getInt("id"));
        medico.setNome(rs.getString("nome"));
        medico.setCrm(rs.getString("crm"));
        medico.setEspecialidade(rs.getString("especialidade"));
        medico.setEmail(rs.getString("email"));
        medico.setSenha(rs.getString("senha"));
        medico.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
        return medico;
    }
}
