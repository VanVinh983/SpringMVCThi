package com.se.dao;

import java.util.List;

import com.se.entity.DeTai;


public interface DeTaiDao {
	public void insert(DeTai deTai);
	public void delete(int id);
	public void update(DeTai deTai);
	public List<DeTai> getGiangViens(int id_giangvien);
	public DeTai getGiangVien(int id);
}
