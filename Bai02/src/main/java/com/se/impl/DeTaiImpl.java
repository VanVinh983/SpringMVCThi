package com.se.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DeTaiDao;
import com.se.entity.DeTai;

@Repository
public class DeTaiImpl implements DeTaiDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void insert(DeTai deTai) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(deTai);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "delete from detai where id ="+id;
		session.createNativeQuery(sql).executeUpdate();
	}

	@Override
	public void update(DeTai deTai) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<DeTai> getGiangViens(int id_giangvien) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from detai where giangvien_id ="+id_giangvien;
		List<DeTai> deTais = session.createNativeQuery(sql, DeTai.class).getResultList();
		return deTais;
	}

	@Override
	@Transactional
	public DeTai getGiangVien(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DeTai.class, id);
	}

}
