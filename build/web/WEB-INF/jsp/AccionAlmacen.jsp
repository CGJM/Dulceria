<%-- 
    Document   : AccionAlmacen
    Created on : 9/08/2019, 08:28:28 AM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accion almacen</title>
    </head>
    <body>
        <form method="post" action="">
            Seleccionar:<SELECT NAME="selCombo" SIZE=1 > 
                <OPTION VALUE="link pagina 1">opcion1</OPTION>
                <OPTION VALUE="link pagina 2">opcion2</OPTION>
                <OPTION VALUE="link pagina 3">opcion3</OPTION>
                <OPTION VALUE="link pagina 4">opcion4</OPTION> 
            </SELECT><br>
            ID Producto:<input type="text" name="idP"><br>
            Nombre: <input type="text" name="nombre"><br>
            Cantidad: <input type="text" name="cantidad"><br>
            Precio: <input type="text" name="precio"><br>
            <input type="submit" name="accion" value="Accion">
        </form>
    </body>
</html>
