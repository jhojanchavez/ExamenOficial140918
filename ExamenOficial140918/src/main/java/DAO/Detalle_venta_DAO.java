/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import modell.Detalle_venta;

/**
 *
 * @author W10
 */
public interface Detalle_venta_DAO {
    public boolean createDetalle_venta(Detalle_venta dv);
    public ArrayList<Detalle_venta> readDetalle_venta();
    public boolean updateDetalle_venta(Detalle_venta dv);
    public boolean deleteDetalle_venta(String id_detalle_venta);
}
