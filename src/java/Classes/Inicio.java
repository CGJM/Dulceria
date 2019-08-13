/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dulceria_53.Autentificacion;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author crist
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("usuario").trim();
            String pass = request.getParameter("contrasena").trim();
            //Inicio_Sesion ini=new Inicio_Sesion();
            //ini.postLogin(datoUno, datoDos);

            RequestDispatcher rd;
            Autentificacion verificar = new Autentificacion(user, pass);
            if (verificar.validacion()) {
                rd = request.getRequestDispatcher("./WEB-INF/jsp/Menu.jsp");
                rd.forward(request, response);
                System.out.println("Accedio");
            } else {
                rd = request.getRequestDispatcher("./WEB-INF/jsp/index.jsp");
                rd.forward(request, response);
                System.out.println("No encontrado");
            }

            //getServletContext().getRequestDispatcher("./jsp/Menu.jsp").forward(request, response); 
            //    Autentificacion verificar = new Autentificacion(datoDos, datoUno);
            //<   if (verificar.validacion()) {
            //     JOptionPane.showMessageDialog(null, "Acceso Autorizado");
            //}
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
