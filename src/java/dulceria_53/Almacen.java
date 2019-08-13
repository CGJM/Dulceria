/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gera
 */
public class Almacen {
  
  private Producto dulce;
  private Empleado usuario;
  private Connection cn;
  
    public boolean Alta(Producto ingreso,Empleado ingresador){
        usuario=ingresador;
        dulce=ingreso;
        boolean resultado = false;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "INSERT INTO Almacen values ('"+dulce.getIdPrducto()+"','"+dulce.getNombre()+"',"+dulce.getCantidad()+
                        ","+dulce.getPrecio()+",'"+usuario.getIdEmpleado()+"');";
            //3. Ejecución de la instrucción
            resultado = st.execute(tsql);
            //4. Cierre de la conexión
            cn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
  
    public int actualizar(String idProducto, int precio, int cantidad, String nombre, String condicion) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);;
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "UPDATE Almacen SET ID ='" + idProducto +"',Nombre ='"+ nombre +"',Cantidad= "+cantidad+",Precio ="+ precio+ 
                    " WHERE Nombre = '"+ condicion +"';";
            //3. Ejecución de la instrucción
            resultado = st.executeUpdate(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al modificar "+e);
        }
        return resultado;
    }
    
    public int eliminar(String condicion) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "DELETE FROM  Almacen WHERE Nombre = '"+ condicion
                    +"';";
            //3. Ejecución de la instrucción
            resultado = st.executeUpdate(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar "+e);
        }
        return resultado;
    }
    
    public ResultSet consultarNombres() {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT Nombre FROM Almacen;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
           // cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet consultaPersonal(String parametro) {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT * FROM Almacen where Nombre='"+parametro+"';";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    
    public ResultSet consultar() {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            //cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Dulceria_53?serverTimezone=UTC", "root", "admon123");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT * FROM Almacen;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
           // cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public ResultSet consultarID(String parametro) {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT ID FROM Almacen where Nombre='"+parametro+"';";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    
    
    public void cerrarConexion()
    {
        try{
        cn.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
