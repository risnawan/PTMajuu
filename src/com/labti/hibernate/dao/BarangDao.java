/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.hibernate.dao;

import com.labti.hibernate.model.Material; 
import java.util.List;
/**
 *
 * @author andhi
 */
public interface BarangDao {
    public void save(Material barang); 
    public void update(Material barang); 
    public void delete(Material barang); 
    public Material getBarang(String idBarang); 
    public List<Material> getBarangs();
}
