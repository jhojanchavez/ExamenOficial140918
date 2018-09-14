/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerImpl;

import DAO.Producto_DAO;
import configbd.conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Producto;

/**
 *
 * @author W10
 */
public class Producto_CrtlImpl implements Producto_DAO{
    conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Producto> listDatos;
    
    public Producto_CrtlImpl(){
        cx = new conexionbd();
    }
    
    @Override
    public boolean createProducto(Producto p){
        sql="INSERT INTO public.producto(id_producto,id_categoria,id_unimed,nombre,descripcion,codigo)"
                + "VALUES("+p.getId_producto()+"','"+p.getId_categoria()+"','"
                +p.getId_unimed()+"','"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getCodigo()+"')";
        return cx.executeInsertUpdate(sql);
    }
    
    @Override
    public ArrayList<Producto> readProducto(){
        listDatos = new ArrayList();
        sql = "SELECT id_producto,id_categoria,id_unimed,nombre,descripcion,codigo "
                + "    FROM public.producto";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Producto(rs.getString("id_producto"),rs.getString("id_categoria"),rs.getString("id_unimed"),rs.getString("nombre"),rs.getString("descripcion"),rs.getString("codigo")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Producto_CrtlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }
    
    @Override
    public boolean updateProducto(Producto p) {
        sql = "UPDATE public.producto SET"
                + " id_categoria = '" + p.getId_categoria() + "' , id_unimed = '" + p.getId_unimed()+ "' , nombre = '" + p.getNombre()+ "', descripcion = '" + p.getDescripcion()+ "', codigo = '" + p.getCodigo()+ "'"
                + " WHERE id_producto = " + p.getId_producto() + " ";
        return cx.executeInsertUpdate(sql);
    }
    
    @Override
    public boolean deleteProducto(String id_producto) {
        sql = "DELETE public.producto "
                + "WHERE id_producto = " + id_producto + " ";
        return cx.executeInsertUpdate(sql);
    }
}
