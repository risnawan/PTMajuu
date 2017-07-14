package com.labti.hibernate.dao;

import com.labti.hibernate.model.Material; 
import java.util.List; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory;

public class BarangDaoImpl implements BarangDao{
    private final SessionFactory sessionFactory; 
    public BarangDaoImpl(SessionFactory sessionFactory) { 
        this.sessionFactory = sessionFactory;
    } 
    
    @Override
    @SuppressWarnings("ConvertToTryWithResources") 
    public void save(Material barang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(barang); 
            session.getTransaction().commit();
        } 
        catch (Exception e) { 
            session.getTransaction().rollback(); 
        } 
        finally {
            session.close(); 
        } 
    }
    
    @Override 
    @SuppressWarnings("ConvertToTryWithResources") 
    public void update(Material barang) { 
        Session session = sessionFactory.openSession();
        try { 
            session.beginTransaction(); 
            session.update(barang); 
            session.getTransaction().commit();
        } 
        catch (Exception e) { 
            session.getTransaction().rollback();
        } 
        finally { 
            session.close(); 
        } 
    } 
    
    @Override 
    @SuppressWarnings("ConvertToTryWithResources") 
    public void delete(Material barang) { 
        Session session = sessionFactory.openSession(); 
        try { 
            session.beginTransaction();
            session.delete(barang); 
            session.getTransaction().commit();
        } 
        catch (Exception e) {
            session.getTransaction().rollback(); 
        } 
        finally { 
            session.close(); 
        } 
    } 
    
    @Override 
    @SuppressWarnings("ConvertToTryWithResources") 
    public Material getBarang(String idBarang) {
        Session session = sessionFactory.openSession(); 
        try { 
            session.beginTransaction(); 
            Material barang = (Material) session.get(Material.class,idBarang); 
            session.getTransaction().commit(); 
            return barang; 
        } 
        catch (Exception e) { 
            session.getTransaction().rollback(); 
            return null; 
        } 
        finally { 
            session.close(); 
        } 
    } 
    
    @Override 
    @SuppressWarnings("ConvertToTryWithResources") 
    public List<Material> getBarangs() {
        Session session = sessionFactory.openSession(); 
        try { 
            session.beginTransaction(); 
            List<Material> barangs = session.createCriteria(Material.class).list(); 
            session.getTransaction().commit(); 
            return barangs; 
        } 
        catch (Exception e) {
            session.getTransaction().rollback(); 
            return null; 
        } 
        finally { 
            session.close(); 
        } 
    } 
}