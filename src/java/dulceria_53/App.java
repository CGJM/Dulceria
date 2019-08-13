/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dulceria_53;


import Interfaces.*;
import java.io.File;

/**
 *
 * @author Gera
 */
public class App {

    Conexion conection;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
            String ruta = "BaseDeDatosDulces.txt";
            File file = new File(ruta);
             if (!file.exists()) {
                 new CrearConexion(ruta).setVisible(true);
             }else{
                 Conexion conectar= new Conexion();
             }
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
