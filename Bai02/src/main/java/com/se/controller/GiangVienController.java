package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.dao.DeTaiDao;
import com.se.dao.GiangVienDao;
import com.se.entity.DeTai;
import com.se.entity.GiangVien;

@Controller
@RequestMapping("giangvien")
public class GiangVienController {
	@Autowired
	private GiangVienDao giangVienDao;
	
	@Autowired
	private DeTaiDao deTaiDao;
	
	@GetMapping("list")
	public String listGiangVien(Model model, HttpSession session) {
		List<GiangVien> giangViens = giangVienDao.getGiangViens();
		model.addAttribute("giangviens", giangViens);
		List<DeTai> deTais = (List<DeTai>) session.getAttribute("dts");
		if (deTais==null) {
			deTais = new ArrayList<DeTai>();
		}
		model.addAttribute("dts", deTais);
		return "list";
	}
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String getDeTais(HttpSession httpSession, @PathVariable("id") int id) {
		httpSession.setAttribute("dts", deTaiDao.getGiangViens(id));
		return "redirect:/giangvien/list";
	}
	@GetMapping("save")
	public String showform(Model model) {
		List<GiangVien> giangViens = giangVienDao.getGiangViens();
		model.addAttribute("giangviens", giangViens);
		model.addAttribute("dt", new DeTai());
		return "formdetai";
	}
	@RequestMapping(value = "/saveform", method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("dt") DeTai deTai, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<GiangVien> giangViens = giangVienDao.getGiangViens();
			model.addAttribute("giangviens", giangViens);
			return "formdetai";
		}else {
			deTaiDao.insert(deTai);
			return "redirect:/giangvien/list";
		}
	}
	@GetMapping("manager")
	public String showmanager(Model model, HttpSession session) {
		List<GiangVien> giangViens = giangVienDao.getGiangViens();
		model.addAttribute("giangviens", giangViens);
		List<DeTai> deTais = (List<DeTai>) session.getAttribute("dts");
		if (deTais==null) {
			deTais = new ArrayList<DeTai>();
		}
		model.addAttribute("dts", deTais);
		return "manager";
	}
	@RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
	public String getdetaimanager(HttpSession httpSession, @PathVariable("id") int id) {
		httpSession.setAttribute("dts", deTaiDao.getGiangViens(id));
		return "redirect:/giangvien/manager";
	}
	@GetMapping("delete")
	public String delete(@RequestParam(value = "delete") int id,@RequestParam(value = "giangvien") int id_giangvien, HttpSession session) {
		deTaiDao.delete(id);
		session.setAttribute("dts", deTaiDao.getGiangViens(id_giangvien));
		return "redirect:/giangvien/manager";
	}
	@GetMapping("update")
	public String update(@RequestParam(value = "update") int id,Model model) {
		List<GiangVien> giangViens = giangVienDao.getGiangViens();
		model.addAttribute("giangviens", giangViens);
		model.addAttribute("dt", deTaiDao.getGiangVien(id));
		return "formdetai";
	}
	
}
