package com.se.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "giangvien")
public class GiangVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenGV;
	private String linhVucNghienCuu;
	private String dienThoai;
	private String email;
	public GiangVien(String tenGV, String linhVucNghienCuu, String dienThoai, String email) {
		super();
		this.tenGV = tenGV;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.dienThoai = dienThoai;
		this.email = email;
	}
	
	public GiangVien() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getLinhVucNghienCuu() {
		return linhVucNghienCuu;
	}
	public void setLinhVucNghienCuu(String linhVucNghienCuu) {
		this.linhVucNghienCuu = linhVucNghienCuu;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GiangVien [id=" + id + ", tenGV=" + tenGV + ", linhVucNghienCuu=" + linhVucNghienCuu + ", dienThoai="
				+ dienThoai + ", email=" + email + "]";
	}
	
	
	
}
