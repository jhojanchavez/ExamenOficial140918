/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerImpl;

import DAO.Detalle_venta_DAO;
import configbd.conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Detalle_venta;
import modell.Producto;

/**
 *
 * @author W10
 */
public class Detalle_venta_CtrlImpl implements Detalle_venta_DAO{
    conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Detalle_venta> listDatos;
    
    public Detalle_venta_CtrlImpl(){
        cx = new conexionbd();
    }
    
    @Override
    public boolean createDetalle_venta(Detalle_venta dv){
        sql="INSERT INTO public.detalle_venta(id_detalle_venta,id_venta,id_producto_stock,item,igv,sub_total,descuento,cantidad,precio_unit)"
                + "VALUES("+dv.getId_detalle_venta()+"','"+dv.getId_venta()+"','"
                +dv.getId_producto_stock()+"','"+dv.getItem()+"','"+dv.getIgv()+"','"+dv.getSub_total()+"','"+dv.getDescuento()+"','"+dv.getCantidad()+"','"+dv.getPrecio_unit()+"')";
        return cx.executeInsertUpdate(sql);
    }
    
    @Override
    public ArrayList<Detalle_venta> readDetalle_venta(){
        listDatos = new ArrayList();
        sql = "SELECT id_detalle_venta,id_venta,id_producto_stock,item,igv,sub_total,descuento,cantidad,precio_unit "
                + "    FROM public.detalle_venta";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Detalle_venta(rs.getString("id_detalle_venta"),rs.getString("id_venta"),rs.getString("id_producto_stock"),rs.getString("item"),rs.getString("igv"),rs.getString("sub_total"),rs.getString("descuento"),rs.getString("cantidad"),rs.getString("precio_unit")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_venta_CtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }
    
    @Override
    public boolean updateDetalle_venta(Detalle_venta dv){
        sql = "UPDATE public.detalle_venta SET"
                + " id_venta = '" + dv.getId_venta()+ "' , id_producto_stock = '" + dv.getId_producto_stock()+ "' , item = '" + dv.getItem()+ "', igv = '" + dv.getIgv()+ "', sub_total = '" + dv.getSub_total()+ "', descuento = '" + dv.getDescuento()+ "', cantidad = '" + dv.getCantidad()+ "', precio_unit = '" + dv.getPrecio_unit()+ "'"
                + " WHERE id_detalle_venta = " + dv.getId_detalle_venta()+ " ";
        return cx.executeInsertUpdate(sql);
    }
    
    @Override
    public boolean deleteDetalle_venta(String id_detalle_venta){
        sql = "DELETE public.detalle_venta "
                + "WHERE id_detalle_venta = " + id_detalle_venta + " ";
        return cx.executeInsertUpdate(sql);
    }
}
