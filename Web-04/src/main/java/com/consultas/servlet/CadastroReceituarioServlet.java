package com.consultas.servlet;

import com.consultas.dao.ReceituarioDAO;
import com.consultas.model.Receituario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro-receituario")
public class CadastroReceituarioServlet extends HttpServlet {
    private ReceituarioDAO receituarioDAO = new ReceituarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int consultaId = Integer.parseInt(request.getParameter("consultaId"));
            String medicamentos = request.getParameter("medicamentos");
            String dosagem = request.getParameter("dosagem");
            String instrucoes = request.getParameter("instrucoes");

            Receituario receituario = new Receituario(consultaId, medicamentos, dosagem, instrucoes);
            
            if (receituarioDAO.inserir(receituario)) {
                response.sendRedirect(request.getContextPath() + "/consulta?id=" + consultaId + "&sucesso=receituario");
            } else {
                response.sendRedirect(request.getContextPath() + "/consulta?id=" + consultaId + "&erro=receituario");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/dashboard?erro=dados");
        }
    }
}
