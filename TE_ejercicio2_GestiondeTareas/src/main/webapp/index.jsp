<%@page import="com.emergentes.Tareas"%>
<%@page import="java.util.ArrayList"%>
<%
    if(session.getAttribute("almacen")==null){
        ArrayList<Tareas> lisaux = new ArrayList<Tareas>();
        session.setAttribute("almacen", lisaux);
    }
    ArrayList<Tareas> almacen = (ArrayList<Tareas>)session.getAttribute("almacen");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tareas Pendientes</title>
    </head>
    <body>
    <center><h1>TAREAS PENDIENTES</h1></center>
      
        <a href="NuevoProducto.jsp">Nuevo</a><br><br>
    
  
        <table border="1">

            <tr>
                <th>id</th>
                <th>Tarea</th>
                <th>Completado</th>
            
                <th></th>
            </tr>
            <%
            if(almacen!=null){
                
                for(Tareas p : almacen){
            
            %>
            <tr>
                <td><%=p.getId() %></td>
                <td><%=p.getTarea() %></td>
                <td><center>  <input type="checkbox" name="completo" value="completo"></center></td>
               
                <td><a href="MainServlet?op=eliminar&id=<%= p.getId() %>">eliminar</a></td>
            </tr><%
                }
                }
            %>
        </table>
    </body>
</html>
