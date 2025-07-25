package com.consultas.servlet;

import com.consultas.dao.ConsultaDAO;
import com.consultas.dao.MedicoDAO;
import com.consultas.dao.PacienteDAO;
import com.consultas.model.Consulta;
import com.consultas.model.Medico;
import com.consultas.model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Servlet responsável pelo cadastro de consultas médicas.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
@WebServlet("/cadastro-consulta")
public class CadastroConsultaServlet extends HttpServlet {
    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();
    private PacienteDAO pacienteDAO = new PacienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Medico> medicos = medicoDAO.listarTodos();
        List<Paciente> pacientes = pacienteDAO.listarTodos();
        
        request.setAttribute("medicos", medicos);
        request.setAttribute("pacientes", pacientes);
        request.getRequestDispatcher("/WEB-INF/views/cadastro-consulta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int medicoId = Integer.parseInt(request.getParameter("medicoId"));
            int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
            String dataHoraStr = request.getParameter("dataHora");
            String observacoes = request.getParameter("observacoes");

            LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            
            Consulta consulta = new Consulta(medicoId, pacienteId, dataHora, observacoes);
            
            if (consultaDAO.inserir(consulta)) {
                request.setAttribute("sucesso", "Consulta cadastrada com sucesso!");
            } else {
                request.setAttribute("erro", "Erro ao cadastrar consulta!");
            }
        } catch (Exception e) {
            request.setAttribute("erro", "Erro ao processar os dados: " + e.getMessage());
        }

        doGet(request, response);
    }
}
