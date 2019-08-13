/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gera
 */
public class Autentificacion {
    private String usuario;
    private String clave;
    private Empleado persona;
    Connection cn;

    public Autentificacion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public boolean validacion(){
        ResultSet resultado = null;
        System.out.println("Entro");
        try {          
            
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria_53?useSSL=false",
                    "root", "Esnafer19");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT * FROM Registro where Usuario='"+getUsuario()+"' and Clave='"+getClave()+"';";
            //3. Ejecución de la instrucción
            
            resultado = st.executeQuery(tsql);
            return (resultado!=null);
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            System.out.println("Error "+e);
            return false;
        }
    }
    
    public Empleado obtenerDatos(){
        ResultSet resultado = null;
        try {           
            Statement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/dulceria_53?useSSL=falseserverTimezone=UTC", "root", "Esnafer19");
            //2. Definición de la instrucción
            st = cn.createStatement();
            String tsql = "SELECT * FROM Registro where Usuario='"+getUsuario()+"';";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            if (resultado != null) {
                while (resultado.next()) {
                    persona=new Empleado(resultado.getString("ID"),resultado.getString("Nombre"),
                    resultado.getString("Apellido"),resultado.getString("Usuario"),resultado.getString("Clave"),
                    resultado.getString("Puesto"),resultado.getString("Imagen"));
                }
            }
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error "+e);
        }
        return persona;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }  
}
