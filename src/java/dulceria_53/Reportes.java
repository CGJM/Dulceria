/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import Interfaces.Menu;
import Interfaces.Vender;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gera
 */
public class Reportes {
    
    Menu menu;
    
    public void crearReporteUsuarios(){
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                HashMap map = new HashMap(); 
                JasperPrint jasperPrint = null;
                String manejador = "com.mysql.jdbc.Driver";
                Connection connection = null;
                try {
                    Class.forName(manejador);
                } catch (Exception e) {
                    System.out.println("Error en la conexion de la base de datos" + e.getMessage());
                    return;
                }
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://" + Conexion.direccionIP + "/" + Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
                } catch (Exception ex) {
                    System.out.println("Error en la conexion de la base de datos" + ex.getMessage());
                }
                map.put("parameter1", "El siguiente documento tiene el fin de mostrar el personal que trabaja en la dulceria 'Falcon'");//Con esto pasa parametros a el reporte
                map.put("parameter2", Conexion.RFC);
                try {
                    jasperPrint = JasperFillManager.fillReport("D:\\85096\\Documents\\NetBeansProjects\\Dulceria_53\\src\\Reportes\\DulceriaEmpleados.jasper", map, connection);
                    net.sf.jasperreports.view.JasperViewer ac = new JasperViewer(jasperPrint, false);
                    ac.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    ac.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " Error en la impresion "+ ex.getMessage());
                }
            }
        });
    }
    public void crearReporteProductos(){
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                HashMap map = new HashMap(); 
                JasperPrint jasperPrint = null;
                String manejador = "com.mysql.jdbc.Driver";
                Connection connection = null;
                try {
                    Class.forName(manejador);
                } catch (Exception e) {
                    System.out.println("Error en la conexion de la base de datos" + e.getMessage());
                    return;
                }
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://" + Conexion.direccionIP + "/" + Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
                } catch (Exception ex) {
                    System.out.println("Error en la conexion de la base de datos" + ex.getMessage());
                }
                //map.put("parameter1", "El siguiente documento tiene el fin de mostrar el personal que trabaja en la dulceria 'Falcon'");//Con esto pasa parametros a el reporte
                //map.put("parameter2", Conexion.RFC);
                try {
                    jasperPrint = JasperFillManager.fillReport("D:\\85096\\Documents\\NetBeansProjects\\Dulceria_53\\src\\Reportes\\ReporteProductos.jasper", null, connection);
                    net.sf.jasperreports.view.JasperViewer ac = new JasperViewer(jasperPrint, false);
                    ac.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    ac.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " Error en la impresion "+ ex.getMessage());
                }
            }
        });

    }
    public void crearReporteVenta(String nombre, String total){
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                HashMap map = new HashMap(); 
                JasperPrint jasperPrint = null;
                String manejador = "com.mysql.jdbc.Driver";
                Connection connection = null;
                try {
                    Class.forName(manejador);
                } catch (Exception e) {
                    System.out.println("Error en la conexion de la base de datos" + e.getMessage());
                    return;
                }
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://" + Conexion.direccionIP + "/" + Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
                } catch (Exception ex) {
                    System.out.println("Error en la conexion de la base de datos" + ex.getMessage());
                }
                map.put("cliente", nombre);//Con esto pasa parametros a el reporte
                map.put("total", "$"+total);
                try {
                    jasperPrint = JasperFillManager.fillReport("D:\\85096\\Documents\\NetBeansProjects\\Dulceria_53\\src\\Reportes\\ReporteVenta.jasper", map, connection);
                    net.sf.jasperreports.view.JasperViewer ac = new JasperViewer(jasperPrint, false);
                    ac.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    ac.setVisible(true);

                        boolean resultado = false;
                        try{
                        Statement st;
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
                        //2. Definición de la instrucción
                        st = cn.createStatement();
                        String tsql = "truncate table Apoyo;";
                        //3. Ejecución de la instrucción
                        resultado = st.execute(tsql);
                        //4. Cierre de la conexión
                        resultado = true;
                        cn.close();
                        }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error"+ e.getMessage());
                        }
                        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " Error en la impresion "+ ex.getMessage());
                }
            }
        });
 
    }

       
}


