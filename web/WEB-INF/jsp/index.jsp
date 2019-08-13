<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <%@ page import='dulceria_53.Autentificacion' %>
          <% System.setProperty("java.awt.headless", "false");%>
    </head>
    
    <body>
        <form method="post" action="Inicio" >
            <h1>Dulceria Falcón</h1>
        <h3>Inicio de sesión</h3>
        Usuario:<input type="text" name="usuario"></input>
        <br>
        <br>
        Contraseña:<input type="password" name="contrasena"></input>
        
        <br>
        <input type="submit" value="Ingresar"   />
        </form>
    </body>
</html>
