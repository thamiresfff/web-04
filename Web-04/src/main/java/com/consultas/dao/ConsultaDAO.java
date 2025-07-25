package com.consultas.dao;

import com.consultas.config.DatabaseConnection;
import com.consultas.model.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados de consultas.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
public class ConsultaDAO {
    private MedicoDAO medicoDAO = new MedicoDAO();
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public boolean inserir(Consulta consulta) {
        String sql = "INSERT INTO consultas (medico_id, paciente_id, data_hora, observacoes, realizada, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, consulta.getMedicoId());
            stmt.setInt(2, consulta.getPacienteId());
            stmt.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
            stmt.setString(4, consulta.getObservacoes());
            stmt.setBoolean(5, consulta.isRealizada());
            stmt.setTimestamp(6, Timestamp.valueOf(consulta.getDataCadastro()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Consulta buscarPorId(int id) {
        String sql = "SELECT * FROM consultas WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Consulta consulta = mapearConsulta(rs);
                consulta.setMedico(medicoDAO.buscarPorId(consulta.getMedicoId()));
                consulta.setPaciente(pacienteDAO.buscarPorId(consulta.getPacienteId()));
                return consulta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Consulta> listarPorMedico(int medicoId) {
        String sql = "SELECT * FROM consultas WHERE medico_id = ? AND realizada = false ORDER BY data_hora";
        List<Consulta> consultas = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, medicoId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Consulta consulta = mapearConsulta(rs);
                consulta.setMedico(medicoDAO.buscarPorId(consulta.getMedicoId()));
                consulta.setPaciente(pacienteDAO.buscarPorId(consulta.getPacienteId()));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public boolean marcarComoRealizada(int consultaId) {
        String sql = "UPDATE consultas SET realizada = true WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, consultaId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean temProntuario(int consultaId) {
        String sql = "SELECT COUNT(*) FROM prontuarios WHERE consulta_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, consultaId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Consulta mapearConsulta(ResultSet rs) throws SQLException {
        Consulta consulta = new Consulta();
        consulta.setId(rs.getInt("id"));
        consulta.setMedicoId(rs.getInt("medico_id"));
        consulta.setPacienteId(rs.getInt("paciente_id"));
        consulta.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
        consulta.setObservacoes(rs.getString("observacoes"));
        consulta.setRealizada(rs.getBoolean("realizada"));
        consulta.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
        return consulta;
    }
}
