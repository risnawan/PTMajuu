/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.hibernate.controller;
import com.labti.hibernate.configuration.BarangTableModel; 
import com.labti.hibernate.configuration.HibernateUtil; 
import com.labti.hibernate.dao.BarangDao; 
import com.labti.hibernate.model.Material; 
import com.labti.hibernate.model.JenisBarang; 
import com.labti.hibernate.view.BarangView; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane; 
/**
 *
 * @author andhi
 */
public class BarangController {
    private final BarangView barangView; 
    private BarangTableModel barangTableModel; 
    private List<Material> barangs; 
    private final BarangDao barangDao = HibernateUtil.getBarangDao(); 
    
    public BarangController(BarangView barangView) { 
        this.barangView = barangView;
    }  
    
    public void tampilData() { 
        barangs = barangDao.getBarangs();
        barangTableModel = new BarangTableModel(barangs); 
        this.barangView.getTableData().setModel(barangTableModel); 
    } 
    
    public void show() { 
        int index = this.barangView.getTableData().getSelectedRow();
        this.barangView.getTxtKode().setText(String.valueOf(this.barangView.getTableData().getValueAt(index, 0)));
        this.barangView.getTxtNama().setText(String.valueOf(this.barangView.getTableData().getValueAt(index, 1))); 
        this.barangView.getCbKategori().setSelectedItem(String.valueOf(this.barangView.getTableData().getValueAt(index, 2))); 
        this.barangView.getCbSatuan().setSelectedItem(String.valueOf(this.barangView.getTableData().getValueAt(index, 3)));
        this.barangView.getTxtHarga().setText(String.valueOf(this.barangView.getTxtHarga().getText()));
        this.barangView.getTxtStok().setText(String.valueOf(this.barangView.getTxtStok().getText()));
    } 
    
    public void clear() { 
        this.barangView.getTxtKode().setText("");
        this.barangView.getTxtNama().setText(""); 
        this.barangView.getTxtHarga().setText(""); 
        this.barangView.getTxtStok().setText(""); 
    } 
    
    public void saveBarang() { 
        Material barang = new Material();
        try { 
        barang.setKode(this.barangView.getTxtKode().getText());
        barang.setNama(this.barangView.getTxtNama().getText()); 
        barang.setKategori(this.barangView.getCbKategori().getSelectedItem().toString());
        barang.setSatuan(this.barangView.getCbSatuan().getSelectedItem().toString());
        barang.setHarga(Integer.parseInt(this.barangView.getTxtHarga().getText()));
        barang.setStok(Integer.parseInt(this.barangView.getTxtStok().getText()));
        } 
        catch (Exception ex) { 
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
 
        barangDao.save(barang); 
        JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan", "info",JOptionPane.INFORMATION_MESSAGE); 
        clear(); 
        tampilData(); 
    } 
 
    public void updateBarang() { 
        Material barang = new Material(); 
        try { 
        barang.setNama(this.barangView.getTxtNama().getText()); 
        barang.setKategori(this.barangView.getCbKategori().getSelectedItem().toString());
        barang.setSatuan(this.barangView.getCbSatuan().getSelectedItem().toString());
        barang.setHarga(Integer.parseInt(this.barangView.getTxtHarga().getText()));
        barang.setStok(Integer.parseInt(this.barangView.getTxtStok().getText()));
//        barang.setNamaBarang(this.barangView.getNamaBarang().getText()); 
//        barang.setJenisBarang(JenisBarang.valueOf(this.barangView .getJenisBarang().getText())); 
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
//            barang.setTanggalKadaluarsa(dateFormat.parse(this.barangView .getTanggalKadaluarsa().getText()));
        } 
        catch (Exception ex) {
            Logger.getLogger(BarangController.class.getName()).log( Level.SEVERE, null, ex); 
        } 
 
        barangDao.update(barang); 
        JOptionPane.showMessageDialog(null, "Data Berhasil di Edit", "info", JOptionPane.INFORMATION_MESSAGE); 
        clear();
        tampilData(); 
    } 
 
    public void deleteBarang() {
        if (this.barangView.getTxtKode().getText() == null) {
            JOptionPane.showMessageDialog(null, "Barang belum dipilih", "error",JOptionPane.ERROR_MESSAGE);
        } 
        else { Material barang = new Material(); 
        barang.setKode(this.barangView.getTxtKode().getText());
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah data ingin dihapus ?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
        if (pilih == JOptionPane.YES_OPTION) { barangDao.delete(barang); 
        JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus", "info", JOptionPane.INFORMATION_MESSAGE);
        clear(); 
        tampilData();
        }
        }
    } 
}