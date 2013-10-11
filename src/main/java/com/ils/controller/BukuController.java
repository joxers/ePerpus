package com.ils.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ils.controller.validator.BukuFormValidator;
import com.ils.dao.BukuDao;
import com.ils.dao.KategoriDao;
import com.ils.entity.Buku;
import com.ils.entity.Kategori;

/**
 * @author danangku
 * 
 */
@Controller
public class BukuController {

	@Autowired
	private BukuDao bukuDao;
	@Autowired
	private KategoriDao kategoriDao;
	@Autowired
	private BukuFormValidator validator;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping("/searchBuku")
	public ModelAndView searchBuku(
			@RequestParam(required = false, defaultValue = "") String judul) {
		ModelAndView mav = new ModelAndView("showBuku");
		List<Buku> bukus = bukuDao.searchBuku(judul.trim());
		mav.addObject("SEARCH_BUKU_RESULTS_KEY", bukus);
		return mav;
	}

	@RequestMapping("/viewAllBuku")
	public ModelAndView getAllBuku() {
		ModelAndView mav = new ModelAndView("showBuku");
		Map referenceData = new HashMap();
		// Map<String,String> kategoris = new LinkedHashMap<String,String>();

		List<Buku> buku = bukuDao.getAllBuku();
		List<Kategori> kategoris = kategoriDao.getAllKategori();
		mav.addObject("SEARCH_BUKU_RESULTS_KEY", buku);
		// mav.addObject("kategoriList", kategoris);
		referenceData.put("kategoriList", kategoris);
		return mav;
	}

	@RequestMapping(value = "/saveBuku", method = RequestMethod.GET)
	public ModelAndView newbukuForm() {
		ModelAndView mav = new ModelAndView("newBuku");
		Buku buku = new Buku();
		List<Kategori> kategoris = kategoriDao.getAllKategori();
		mav.getModelMap().put("newBuku", buku);
		mav.addObject("kategoris", kategoris);
		return mav;
	}

	@RequestMapping(value = "/saveBuku", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("newBuku") Buku buku,
			BindingResult result) {
		validator.validate(buku, result);
		if (result.hasErrors()) {
			return new ModelAndView("newBuku");
		}
		bukuDao.save(buku);
		return new ModelAndView("redirect:viewAllBuku.do");

	}

	@RequestMapping(value = "/updateBuku", method = RequestMethod.GET)
	public ModelAndView editBuku(@RequestParam("idBuku") Integer idBuku) {
		ModelAndView mav = new ModelAndView("editBuku");
		Buku buku = bukuDao.getById(idBuku);
		List<Kategori> kategoris = kategoriDao.getAllKategori();
		mav.addObject("editBuku", buku);
		mav.addObject("kategoris", kategoris);
		return mav;
	}

	// @RequestMapping(value="/updateBuku", method=RequestMethod.POST)
	// public String update(@ModelAttribute("editBuku") Buku buku, BindingResult
	// result, SessionStatus status){
	// validator.validate(buku, result);
	// if (result.hasErrors()) {
	// return "editBuku";
	// }
	// bukuDao.update(buku);
	// status.setComplete();
	// return "redirect:viewAllBuku.do";
	// }
	@RequestMapping(value = "/updateBuku", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("editBuku") Buku buku,
			BindingResult result, SessionStatus status) {
		validator.validate(buku, result);
		if (result.hasErrors()) {
			return new ModelAndView("editBuku");
		}
		bukuDao.update(buku);
		 status.setComplete();

		return new ModelAndView("redirect:viewAllBuku.do");

	}

	@RequestMapping("deleteBuku")
	public ModelAndView delete(@RequestParam("idBuku") Integer idBuku) {
		ModelAndView mav = new ModelAndView("redirect:viewAllBuku.do");
		bukuDao.delete(idBuku);
		return mav;
	}

}
