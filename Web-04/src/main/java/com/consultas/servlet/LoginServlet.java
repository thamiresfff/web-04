package com.consultas.servlet;

import com.consultas.dao.MedicoDAO;
import com.consultas.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet responsável pelo login de médicos no sistema.
 * 
 * @author thamfernandes
 * @version 1.0
 * @since 2025
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private MedicoDAO medicoDAO = new MedicoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (medicoDAO.autenticar(email, senha)) {
            Medico medico = medicoDAO.buscarPorEmail(email);
            HttpSession session = request.getSession();
            session.setAttribute("medico", medico);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            request.setAttribute("erro", "Email ou senha inválidos");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
