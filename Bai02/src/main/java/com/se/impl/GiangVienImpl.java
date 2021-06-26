package com.se.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.GiangVienDao;
import com.se.entity.GiangVien;

@Repository
public class GiangVienImpl implements GiangVienDao{

	@Autowired
	private SessionFactory SessionFactory;
	
	
	@Override
	@Transactional
	public void insert(GiangVien giangVien) {
		Session session = SessionFactory.getCurrentSession();
		session.save(giangVien);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactory.getCurrentSession();
		String sql = "delete from giangvien where id ="+id;
		session.createNativeQuery(sql).executeUpdate();
		
	}
	@Transactional
	@Override
	public void update(GiangVien giangVien) {
		// TODO Auto-generated method stub
		Session session = SessionFactory.getCurrentSession();
		session.update(giangVien);
	}
	@Transactional
	@Override
	public List<GiangVien> getGiangViens() {
		Session session = SessionFactory.getCurrentSession();
		String sql = "select * from giangvien";
		List<GiangVien> list = session.createNativeQuery(sql, GiangVien.class).getResultList();
		return list;
	}
	@Transactional
	@Override
	public GiangVien getGiangVien(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactory.getCurrentSession();
		return session.get(GiangVien.class, id);
	}

}
