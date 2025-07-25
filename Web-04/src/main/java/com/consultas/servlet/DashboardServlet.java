package com.consultas.servlet;

import com.consultas.dao.ConsultaDAO;
import com.consultas.model.Consulta;
import com.consultas.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet responsável pelo dashboard do médico.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("medico") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Medico medico = (Medico) session.getAttribute("medico");
        List<Consulta> consultas = consultaDAO.listarPorMedico(medico.getId());
        
        request.setAttribute("consultas", consultas);
        request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
    }
}
