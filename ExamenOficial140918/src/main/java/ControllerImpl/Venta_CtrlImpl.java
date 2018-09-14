/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerImpl;

import DAO.Venta_DAO;
import configbd.conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Venta;

/**
 *
 * @author W10
 */
public class Venta_CtrlImpl implements Venta_DAO{
    conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Venta> listDatos;
    
    public Venta_CtrlImpl(){
        cx = new conexionbd();
    }
    
    @Override
    public boolean createVenta(Venta v){
        sql="INSERT INTO public.venta(id_venta,id_cliente_direccion,id_vendedor,fecha,concepto,igv,total,sub_total)"
                + "VALUES("+v.getId_venta()+"','"+v.getId_cliente_direccion()+"','"
                +v.getId_vendedor()+"','"+v.getFecha()+"','"+v.getConcepto()+"','"+v.getIgv()+"','"+v.getTotal()+"','"+v.getSub_total()+"')";
        return cx.executeInsertUpdate(sql);
    }
    
    @Override
    public ArrayList<Venta> readVenta(){
        listDatos = new ArrayList();
        sql = "SELECT id_venta,id_cliente_direccion,id_vendedor,fecha,concepto,igv,total,sub_total "
                + "    FROM public.venta";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Venta(rs.getString("id_venta"),rs.getString("id_cliente_direccion"),rs.getString("id_vendedor"),rs.getString("fecha"),rs.getString("concepto"),rs.getString("igv"),rs.getString("total"),rs.getString("sub_total")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Venta_CtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }
    
    @Override
    public boolean updateVenta(Venta v){
        sql = "UPDATE public.venta SET"
                + " id_cliente_direccion = '" + v.getId_cliente_direccion()+ "', id_vendedor = '" + v.getId_vendedor()+ "' , fecha = '" + v.getFecha()+ "', concepto = '" + v.getConcepto()+ "', igv = '" + v.getIgv()+ "', total = '" + v.getTotal()+ "', sub_total = '" + v.getSub_total()+ "'"
                + " WHERE id_venta = " + v.getId_venta()+ " ";
        return cx.executeInsertUpdate(sql);
    }
    
    @Override
    public boolean deleteVenta(String id_venta){
        sql = "DELETE public.venta "
                + "WHERE id_venta = " + id_venta + " ";
        return cx.executeInsertUpdate(sql);
    }
}
