
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SaludoServlet", urlPatterns = {"/SaludoServlet"})
public class SaludoServlet extends HttpServlet {

 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            int contador=0;
      //obtener el arreglo de cookies del cliente
        Cookie[] cukis = request.getCookies();
        
        if(cukis!=null){
            for(Cookie c : cukis){
                
                if(c.getName().equals("visitas")){
                    //CONVERSION DE CADENA A ENTERO
                    contador=Integer.parseInt(c.getValue());
                    
                }
            }
        }
        contador++;
        //
        Cookie c = new Cookie("visitas", Integer.toString(contador));
      
        c.setMaxAge(30);
        response.addCookie(c);
        //generando contenido apartir del servlet
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
       
          int x =contador;
          
        if(x>=2){
            out.println("Bienvenido nuevamente");
        }else{
            out.println("Bienvenido a nuestro sitio web");
        }
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
