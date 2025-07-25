package com.consultas.dao;

import com.consultas.config.DatabaseConnection;
import com.consultas.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados de pacientes.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class PacienteDAO {

    public boolean inserir(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nome, cpf, data_nascimento, telefone, email, endereco, data_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, Date.valueOf(paciente.getDataNascimento()));
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getEmail());
            stmt.setString(6, paciente.getEndereco());
            stmt.setTimestamp(7, Timestamp.valueOf(paciente.getDataCadastro()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Paciente buscarPorId(int id) {
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearPaciente(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Paciente> listarTodos() {
        String sql = "SELECT * FROM pacientes ORDER BY nome";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                pacientes.add(mapearPaciente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public List<Paciente> buscarPorNome(String nome) {
        String sql = "SELECT * FROM pacientes WHERE nome LIKE ? ORDER BY nome";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                pacientes.add(mapearPaciente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    private Paciente mapearPaciente(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(rs.getInt("id"));
        paciente.setNome(rs.getString("nome"));
        paciente.setCpf(rs.getString("cpf"));
        paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        paciente.setTelefone(rs.getString("telefone"));
        paciente.setEmail(rs.getString("email"));
        paciente.setEndereco(rs.getString("endereco"));
        paciente.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
        return paciente;
    }
}
