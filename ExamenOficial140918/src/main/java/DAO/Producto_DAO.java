/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import modell.Producto;

/**
 *
 * @author W10
 */
public interface Producto_DAO {
    public boolean createProducto(Producto p);
    public ArrayList<Producto> readProducto();
    public boolean updateProducto(Producto p);
    public boolean deleteProducto(String id_producto);
}
