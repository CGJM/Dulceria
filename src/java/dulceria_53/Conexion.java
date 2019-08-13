/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import Interfaces.Login;
import Interfaces.Splash;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Gera
 */
public final class Conexion {
    
    public static String ruta="BaseDeDatosDulces.txt";
    public static String direccionIP;
    public static String nombreBD;
    public static String usuario;
    public static String clave;
    public static final String RFC = "GLRW1808162H5";
    public static ColaVentas venta = new ColaVentas();

    public Conexion() {
        obtenerConexion();
    }
    public static void obtenerConexion(){
        File f = new File(ruta);
        if (f.exists()) {
            try{
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                direccionIP=bf.readLine();
                nombreBD=bf.readLine();
                usuario=bf.readLine();
                clave=bf.readLine();
                bf.close();
                new Splash(venta).setVisible(true);
                //new Login(venta).setVisible(true);
            }catch(Exception e){
                //e.printStackTrace();
            }   
        }else{
            
        }
    }
    public static boolean probarConexion(String direccion,String nombre,String usuario, String clave){
        boolean bandera = false;
        ResultSet resultado = null;
        if (direccion.equals("127.0.0.1")) {
                
                try {           
                    Statement st;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+nombre+"?serverTimezone=UTC", usuario, clave);
                     //2. Definición de la instrucción
                     st = cn.createStatement();
                     String tsql = "SELECT * FROM Registro;";
                     //3. Ejecución de la instrucción
                     resultado = st.executeQuery(tsql);
                     bandera = true;
                     //4. Cierre de la conexión
                      cn.close(); 
                } catch (Exception e) {
                    //e.printStackTrace();
                    bandera = false;
                }
            }else
                bandera = false;
        
        return bandera;
        
    }
}
