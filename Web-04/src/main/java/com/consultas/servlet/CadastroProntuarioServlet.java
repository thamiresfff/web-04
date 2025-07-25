package com.consultas.servlet;

import com.consultas.dao.ConsultaDAO;
import com.consultas.dao.ProntuarioDAO;
import com.consultas.model.Prontuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro-prontuario")
public class CadastroProntuarioServlet extends HttpServlet {
    private ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int consultaId = Integer.parseInt(request.getParameter("consultaId"));
            String sintomas = request.getParameter("sintomas");
            String diagnostico = request.getParameter("diagnostico");
            String tratamento = request.getParameter("tratamento");
            String observacoes = request.getParameter("observacoes");

            Prontuario prontuario = new Prontuario(consultaId, sintomas, diagnostico, tratamento, observacoes);
            
            if (prontuarioDAO.inserir(prontuario)) {
                consultaDAO.marcarComoRealizada(consultaId);
                response.sendRedirect(request.getContextPath() + "/consulta?id=" + consultaId + "&sucesso=prontuario");
            } else {
                response.sendRedirect(request.getContextPath() + "/consulta?id=" + consultaId + "&erro=prontuario");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/dashboard?erro=dados");
        }
    }
}
