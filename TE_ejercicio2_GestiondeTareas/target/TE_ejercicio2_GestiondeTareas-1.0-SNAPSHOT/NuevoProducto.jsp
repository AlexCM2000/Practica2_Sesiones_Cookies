<%-- 
    Document   : NuevoProducto
    Created on : 28 mar. 2022, 18:07:20
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Registrar Nueva Tarea</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>Id </td>
                    <td><input type="text" name="id" value="0" size="2"></td>
                </tr>
                <tr>
                    <td>Tarea </td>
                    <td><input type="text" name="producto" value=""></td>
                </tr>
             <!--   <tr>
                    <td>Completado </td>
                    <td><input type="checkbox" name="completado" value="completado"></td>
                    <td><input type="text" name="cantidad" value="0"></td> 
                </tr>  -->
               
                <tr>
                    <td></td>
                    <td><a href="index.jsp"><input type="submit"  value="Procesar"></a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
