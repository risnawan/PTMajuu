package com.labti.hibernate.dao;

import com.labti.hibernate.model.Material; 
import java.util.List;


public interface BarangDao {
    public void save(Material barang); 
    public void update(Material barang); 
    public void delete(Material barang); 
    public Material getBarang(String idBarang); 
    public List<Material> getBarangs();
}
