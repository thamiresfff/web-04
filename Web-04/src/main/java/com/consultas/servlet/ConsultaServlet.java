package com.consultas.servlet;

import com.consultas.dao.ConsultaDAO;
import com.consultas.dao.ExameDAO;
import com.consultas.dao.ProntuarioDAO;
import com.consultas.dao.ReceituarioDAO;
import com.consultas.model.Consulta;
import com.consultas.model.Exame;
import com.consultas.model.Prontuario;
import com.consultas.model.Receituario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet responsável pela visualização de detalhes da consulta.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
@WebServlet("/consulta")
public class ConsultaServlet extends HttpServlet {
    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
    private ReceituarioDAO receituarioDAO = new ReceituarioDAO();
    private ExameDAO exameDAO = new ExameDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int consultaId = Integer.parseInt(request.getParameter("id"));
        
        Consulta consulta = consultaDAO.buscarPorId(consultaId);
        if (consulta == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Prontuario prontuario = prontuarioDAO.buscarPorConsulta(consultaId);
        Receituario receituario = receituarioDAO.buscarPorConsulta(consultaId);
        Exame exame = exameDAO.buscarPorConsulta(consultaId);

        request.setAttribute("consulta", consulta);
        request.setAttribute("prontuario", prontuario);
        request.setAttribute("receituario", receituario);
        request.setAttribute("exame", exame);
        
        request.getRequestDispatcher("/WEB-INF/views/consulta.jsp").forward(request, response);
    }
}
