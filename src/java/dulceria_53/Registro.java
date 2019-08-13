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
public class Registro {
    
    private Empleado usuario;
    private Connection cn;
    
    public boolean Alta(Empleado ingresado){
        usuario=ingresado;
        boolean resultado = false;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "INSERT INTO Registro values ('"+usuario.getIdEmpleado()+"','"+usuario.getNombre()+"','"+usuario.getApellido()+
                        "','"+usuario.getUsuario()+"','"+usuario.getClave()+"','"+usuario.getPuesto()+"','"+usuario.getFoto()+"');";
            //3. Ejecución de la instrucción
            resultado = st.execute(tsql);
            //4. Cierre de la conexión
            cn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar "+e);
            return false;
        }
    }
    
    
    public int eliminar(String condicion) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "DELETE FROM  Registro WHERE ID = '"+ condicion
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
    
    public int actualizar(String id, String nombre, String apellido, String usuario, String clave, String puesto, String condicion) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "UPDATE Registro SET ID ='" + id +"',Nombre ='"+ nombre +"', Apellido='"+apellido+"', Usuario ='"+usuario+"',Clave ='"+ clave+ 
                    "', Puesto='"+puesto+"' WHERE ID = '"+ condicion +"';";
            //3. Ejecución de la instrucción
            resultado = st.executeUpdate(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al modificar "+e);
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
            String tsql = "SELECT * FROM Registro where ID='"+parametro+"';";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    
    public ResultSet consultarId() {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT ID FROM Registro;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
           // cn.close(); 
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
            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT * FROM Registro;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
           // cn.close(); 
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

    public Empleado getUsuario() {
        return usuario;
    }

}
