package com.se.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detai")
public class DeTai implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 1, max = 100, message = "khong duoc it hon 1 va lon hon 100 ky tu")
	@Pattern(regexp = "^[A-Z][\\w]*$|^[A-Z][\\w]*(\\s[A-Z][\\w]*)*", message = "ten phai co ky tu dau tien viet hoa")
	private String tenDeTai;
	
	@NotNull
	@Min(value = 1900, message = "nam phai lon hon 1900")
	private int nam;
	
	@NotNull
	@Size(min = 1, message = "khong duoc de rong")
	private String moTa;
	
	@NotNull
	@Size(min = 1, message = "khong duoc de rong")
	private String urlHinh;
	
	@ManyToOne
	@JoinColumn(name = "giangvien_id")
	private GiangVien giangVien;
	public DeTai(String tenDeTai, int nam, String moTa, String urlHinh, GiangVien giangVien) {
		super();
		this.tenDeTai = tenDeTai;
		this.nam = nam;
		this.moTa = moTa;
		this.urlHinh = urlHinh;
		this.giangVien = giangVien;
	}
	public DeTai() {
		super();
	}
	
	public DeTai(String tenDeTai, int nam, String moTa, String urlHinh) {
		super();
		this.tenDeTai = tenDeTai;
		this.nam = nam;
		this.moTa = moTa;
		this.urlHinh = urlHinh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getUrlHinh() {
		return urlHinh;
	}
	public void setUrlHinh(String urlHinh) {
		this.urlHinh = urlHinh;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
}
