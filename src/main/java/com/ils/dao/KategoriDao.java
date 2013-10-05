package com.ils.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ils.entity.Kategori;

/**
 * @author danangku
 *
 */

@Repository
@Transactional
public class KategoriDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Kategori getById(int idKategori){
		return (Kategori) sessionFactory.getCurrentSession().get(Kategori.class, idKategori);
	}
	
	@SuppressWarnings("unchecked")
	 public List<Kategori> searchKategori(String kategori)
	 {
	  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Kategori.class);
	  criteria.add(Restrictions.ilike("kategori", kategori +"%" + "%"));
	  return criteria.list();
	 }
	 
	 @SuppressWarnings("unchecked")
	 public List<Kategori> getAllKategori()
	 {
	  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Kategori.class);
	  return criteria.list();
	 }
	 
	 public int save(Kategori kategori){
	  return (Integer) sessionFactory.getCurrentSession().save(kategori);
	 }
	 
	 public Kategori getKategori(int idKategori) {
			Kategori kategori = (Kategori) sessionFactory.getCurrentSession().get(Kategori.class, idKategori);
			return kategori;
		}
	 
	 public void update(Kategori kategori){
		 Kategori kategoriToUpdate = getKategori(kategori.getIdKategori());
		 kategoriToUpdate.setKategori(kategori.getKategori());
		 

		 sessionFactory.getCurrentSession().update(kategoriToUpdate);
//	  sessionFactory.getCurrentSession().update(kategori);
	 }
	 
	 public void delete(int idKategori){
	  Kategori c = getById(idKategori);
	  sessionFactory.getCurrentSession().delete(c);
	 }

	}
