/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.hibernate.configuration;
import com.labti.hibernate.model.Material; 
import java.util.ArrayList; 
import java.util.List; 
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author andhi
 */
public class BarangTableModel extends AbstractTableModel {
    private List<Material> barangs = new ArrayList<>(); 
    private final String HEADER[] = {"Kode", "Nama", "Kategori", "Satuan", "Harga", "Stok"}; 
    
    public BarangTableModel(List<Material> barangs) { 
        this.barangs = barangs; 
    } 
    
    @Override 
    public int getRowCount() { 
        return barangs.size(); 
    } 
    
    @Override 
    public int getColumnCount() {
        return HEADER.length; 
    } 
 
    @Override 
    public String getColumnName(int columnIndex) {
        return HEADER[columnIndex]; 
    } 
 
    @Override 
    public Object getValueAt(int rowIndex, int columnIndex) { 
        Material barang = barangs.get(rowIndex); 
        switch (columnIndex) { 
            case 0: return barang.getKode();
            case 1: return barang.getNama(); 
            case 2: return barang.getKategori();
            case 3: return barang.getSatuan();
            case 4: return barang.getHarga();
            case 5: return barang.getStok();
            default: return null; }
    }
} 