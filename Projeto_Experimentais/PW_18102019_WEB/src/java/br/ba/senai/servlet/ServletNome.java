/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.servlet;

import br.ba.senai.beans.Calculadora;
import br.ba.senai.beans.Calculo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows
 */
public class ServletNome extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //////////////////////////////////////////////////////////
        
        String valor1 = request.getParameter("txtValor1");
        double v1 = Double.parseDouble(valor1);
        
        String valor2 = request.getParameter("txtValor2");
        double v2 = Double.parseDouble(valor2);      
        
        char operacao = request.getParameter("op").charAt(0);
        
        //double resultado = 0;
        
        //Calculo calc = new Calculo();
        
//        switch(operacao){
//            case '+':  resultado = calc.Somar(v1, v2);  break;
//            case '-':  resultado = calc.Subtrair(v1, v2); break;
//            case '*':  resultado = calc.Multiplicar(v1, v2); break;
//            case '/':  resultado = calc.Dividir(v1, v2); break;
//        }
        Calculadora hp = new Calculadora(v1, v2, operacao);
        hp.Calcular();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletNome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado: " + hp.getRes() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
