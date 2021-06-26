package com.se.dao;

import java.util.List;

import com.se.entity.GiangVien;

public interface GiangVienDao {
	public void insert(GiangVien giangVien);
	public void delete(int id);
	public void update(GiangVien giangVien);
	public List<GiangVien> getGiangViens();
	public GiangVien getGiangVien(int id);
}
