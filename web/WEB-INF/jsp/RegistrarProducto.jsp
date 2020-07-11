<%-- 
    Document   : RegistrarProducto
    Created on : 16/08/2019, 11:30:35 PM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Registrar producto</title>
    </head>
    <body class="text-center">
        <nav class="navbar navbar-expand-lg " style="background-color: red;">
            <a class="navbar-brand"  href="RedireccionFalcon" style="color:black">Falcon</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse nav-item active" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">


                        <a class="nav-link dropdown-toggle nav-item active" style="color:black" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Almacen
                        </a>
                        <div class="dropdown-menu" style="color:black" aria-labelledby="Almacen">
                            <a class="dropdown-item" href="AccesoAlmacen">Ingresar producto</a>
                            <a class="dropdown-item" href="AccionesAlmacen">Acciones</a>
                        </div>
                    </li> 


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle nav-item active" style="color:black" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ventas
                        </a>
                        <div class="dropdown-menu" style="color:black" aria-labelledby="Ventas">
                            <a class="dropdown-item" href="Vent">Ventas</a>
                            <a class="dropdown-item" href="RegVentas">Realizar Venta</a>
                        </div>
                    </li> 


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" style="color:black" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Usuarios
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item"  href="AccesoUsuarios">Agregar usuario</a>
                            <a class="dropdown-item" href="AccionesRegistro">Acciones</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">

                </form>
            </div>
        </nav>
        <br><br>
        <h2>Registro de productos</h2>
        <br>
        <form class="form-signin"  method="POST" action="RegistroProd">
            <div class="form-group container col-md-3">
                    <input class="form-control" placeholder="ID Producto" type="text" name="idP"><br>
                    <input class="form-control" placeholder="Nombre"type="text" name="nombre"><br>
                    <input class="form-control" placeholder="Cantidad" type="text" name="cantidad"><br>
                    <input  class="form-control" placeholder="Precio" type="text" name="precio"><br>
                    <input type="submit" name="accion" class="btn btn-primary btn-block" value="Registrar">
            </div>
        </form>
    </body>
</html>
