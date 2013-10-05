package com.ils.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ils.entity.Buku;

/**
 * @author danangku
 *
 */

@Repository
@Transactional
public class BukuDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Buku getById(int idBuku){
		return (Buku) sessionFactory.getCurrentSession().get(Buku.class, idBuku);
	}
	
	@SuppressWarnings("unchecked")
	 public List<Buku> searchBuku(String judul)
	 {
	  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Buku.class);
	  criteria.add(Restrictions.ilike("judul", judul +"%" + "%"));
	  return criteria.list();
	 }
	 
	 @SuppressWarnings("unchecked")
	 public List<Buku> getAllBuku()
	 {
	  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Buku.class);
	  return criteria.list();
	 }
	 
	 public int save(Buku buku){
	  return (Integer) sessionFactory.getCurrentSession().save(buku);
	 }
	 
	 public Buku getBuku(int idBuku) {
			Buku buku = (Buku) sessionFactory.getCurrentSession().get(Buku.class, idBuku);
			return buku;
		}
	 
	 public void update(Buku buku){
		 Buku bukuToUpdate = getBuku(buku.getIdBuku());
		 bukuToUpdate.setJudul(buku.getJudul());
		 bukuToUpdate.setTglBeli(buku.getTglBeli());
		 bukuToUpdate.setPenerbit(buku.getPenerbit());

		 sessionFactory.getCurrentSession().update(bukuToUpdate);
//	  sessionFactory.getCurrentSession().update(buku);
	 }
	 
	 public void delete(int idBuku){
	  Buku c = getById(idBuku);
	  sessionFactory.getCurrentSession().delete(c);
	 }

	}
