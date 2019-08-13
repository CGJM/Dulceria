<%-- 
    Document   : AccionUsuarios
    Created on : 9/08/2019, 09:18:04 AM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method="post" action="">
            Seleccionar:<SELECT NAME="selCombo" SIZE=1 > 
                <OPTION VALUE="link pagina 1">opcion1</OPTION>
                <OPTION VALUE="link pagina 2">opcion2</OPTION>
                <OPTION VALUE="link pagina 3">opcion3</OPTION>
                <OPTION VALUE="link pagina 4">opcion4</OPTION> 
            </SELECT><br>
            Nombre: <input type="text" name="idP"><br>
            Apellido: <input type="text" name="nombre"><br>
            Usuario: <input type="text" name="cantidad"><br>
            Clave: <input type="text" name="precio"><br>
            Puesto:<select name="puesto">
                
            </select><br>
            Identificador: <input type="text" name="identificador">
            <input type="submit" name="accion" value="Accion">
        </form>
    </body>
</html>
