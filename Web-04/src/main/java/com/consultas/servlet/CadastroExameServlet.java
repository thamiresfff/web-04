package com.consultas.servlet;

import com.consultas.dao.ExameDAO;
import com.consultas.model.Exame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/cadastro-exame")
public class CadastroExameServlet extends HttpServlet {
    private ExameDAO exameDAO = new ExameDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int consultaId = Integer.parseInt(request.getParameter("consultaId"));
            String tipoExame = request.getParameter("tipoExame");
            String descricao = request.getParameter("descricao");
            String resultado = request.getParameter("resultado");
            String dataExameStr = request.getParameter("dataExame");

            LocalDateTime dataExame = LocalDateTime.parse(dataExameStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            
            Exame exame = new Exame(consultaId, tipoExame, descricao, resultado, dataExame);
            
            if (exameDAO.inserir(exame)) {
                response.sendRedirect(request.getContextPath() + "/consulta?id=" + consultaId + "&sucesso=exame");
            } else {
                response.sendRedirect(request.getContextPath() + "/consulta?id=" + consultaId + "&erro=exame");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/dashboard?erro=dados");
        }
    }
}
