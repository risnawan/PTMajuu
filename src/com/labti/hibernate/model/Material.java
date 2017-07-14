/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.hibernate.model;

import java.io.Serializable; 
import java.util.Date; 
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.EnumType; 
import javax.persistence.Enumerated; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.Table;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; 
import org.hibernate.annotations.GenericGenerator; 
 
@Entity @Table(name = "tb_material") 
/**
 *
 * @author andhi
 */
public class Material implements Serializable {
    @Id 
    @Column(name = "id", length = 15) 
    private String id;
    
    @Column(name = "nama", length = 50) 
    private String nama;
    
    @Column(name = "kategori", length = 20)
    private String kategori;
    
    @Column(name = "satuan", length = 20)
    private String satuan;
    
    @Column(name = "harga", length = 11)
    private Integer harga;
    
    @Column(name ="stok", length = 10)
    private Integer stok;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the satuan
     */
    public String getSatuan() {
        return satuan;
    }

    /**
     * @param satuan the satuan to set
     */
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    /**
     * @return the harga
     */
    public Integer getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    /**
     * @return the stok
     */
    public Integer getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(Integer stok) {
        this.stok = stok;
    }

}
