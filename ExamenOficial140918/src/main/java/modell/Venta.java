/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

/**
 *
 * @author W10
 */
public class Venta {
    String id_venta;
    String id_cliente_direccion;
    String id_vendedor;
    String fecha;
    String concepto;
    String igv;
    String total;
    String sub_total;

    public Venta(String id_venta, String id_cliente_direccion, String id_vendedor, String fecha, String concepto, String igv, String total, String sub_total) {
        this.id_venta = id_venta;
        this.id_cliente_direccion = id_cliente_direccion;
        this.id_vendedor = id_vendedor;
        this.fecha = fecha;
        this.concepto = concepto;
        this.igv = igv;
        this.total = total;
        this.sub_total = sub_total;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_cliente_direccion() {
        return id_cliente_direccion;
    }

    public void setId_cliente_direccion(String id_cliente_direccion) {
        this.id_cliente_direccion = id_cliente_direccion;
    }

    public String getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(String id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSub_total() {
        return sub_total;
    }

    public void setSub_total(String sub_total) {
        this.sub_total = sub_total;
    }
    
}
