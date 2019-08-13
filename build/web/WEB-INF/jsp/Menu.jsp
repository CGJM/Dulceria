<%-- 
    Document   : Menu
    Created on : 8/08/2019, 06:44:34 PM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>

    </head>
    <body>
        <h1>Dulceria Falcon</h1>
        Bienvenido: ${nombre}
        <br>
        <a href="AccesoAlmacen"><input type="submit" value="Almacen" /></a>
        <a  href="AccesoVentas"><input type="submit" value="Ventas"></a>
        <a href="AccesoUsuarios"><input type="submit" value="Usarios"></a>
        <a><input type="submit" value="Consulta"></a>
        <img src="">
        
        <a><input type="submit" name="cerrar" value="Cerrar sesion"></a>
    </body>
</html>
