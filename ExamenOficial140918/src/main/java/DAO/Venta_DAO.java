/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import modell.Venta;

/**
 *
 * @author W10
 */
public interface Venta_DAO {
    public boolean createVenta(Venta v);
    public ArrayList<Venta> readVenta();
    public boolean updateVenta(Venta v);
    public boolean deleteVenta(String id_venta);
}
