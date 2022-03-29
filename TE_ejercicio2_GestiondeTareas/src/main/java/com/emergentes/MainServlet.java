package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op.equals("vaciar")) {
            //vaciar carrito
            HttpSession ses = request.getSession();
            ses.invalidate();
            response.sendRedirect("index.jsp");
        }
        if(op.equals("eliminar")){
            //eliminar el producto del carrito
            int pos=-1;
            int buscado=-1;
            int id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses=request.getSession();
            ArrayList<Tareas> lista=(ArrayList<Tareas>)ses.getAttribute("almacen");
       
            for(Tareas p : lista){
                pos++;
                if(p.getId()==id){
                    buscado=pos;
                    
                }
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String producto = request.getParameter("producto");
     //   String[] completado = request.getParameterValues("completado");
        

        Tareas prod = new Tareas();

        prod.setId(id);
        prod.setTarea(producto);
      //  prod.setCompletado(completado);
     
        HttpSession ses = request.getSession();

        ArrayList<Tareas> lista = (ArrayList<Tareas>) ses.getAttribute("almacen");

        lista.add(prod);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
