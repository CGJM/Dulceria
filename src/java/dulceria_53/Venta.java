/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

/**
 *
 * @author Gera
 */
public class Venta {
    
    private String producto;
    private String cantidad;
    private String total;
    private String codigo;

    public Venta(String producto, String cantidad, String total, String codigo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getTotal() {
        return total;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    
}
