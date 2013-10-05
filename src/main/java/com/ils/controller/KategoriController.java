package com.ils.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.ils.controller.validator.KategoriValidator;
import com.ils.dao.KategoriDao;
import com.ils.entity.Kategori;

/**
 * @author danangku
 *
 */
@Controller
public class KategoriController {

	@Autowired
	private KategoriDao kategoriDao;
	@Autowired
	private KategoriValidator validator;

	

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				dateFormat, true));
//	}
	
	@RequestMapping("/searchKategori")
	public ModelAndView searchKategori(@RequestParam(required= false, defaultValue="") String kategori)
	{
		ModelAndView mav = new ModelAndView("kategori/showKategori");
		List<Kategori> kategoris = kategoriDao.searchKategori(kategori.trim());
		mav.addObject("SEARCH_KATEGORI_RESULTS_KEY", kategoris);
		return mav;
	}

	@RequestMapping("/viewAllKategori")
	public ModelAndView getAllKategori() {
		ModelAndView mav = new ModelAndView("kategori/showKategori");
		List<Kategori> kategori = kategoriDao.getAllKategori();
		mav.addObject("SEARCH_KATEGORI_RESULTS_KEY", kategori);
		return mav;
	}

	@RequestMapping(value = "/saveKategori", method = RequestMethod.GET)
	public ModelAndView newkategoriForm() {
		ModelAndView mav = new ModelAndView("kategori/newKategori");
		Kategori kategori = new Kategori();
		mav.getModelMap().put("newKategori", kategori);
		return mav;
	}
	
	@RequestMapping(value="/saveKategori", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newKategori")Kategori kategori, BindingResult result, SessionStatus status)
	 {
	  validator.validate(kategori, result);
	  if (result.hasErrors()) 
	  {    
	   return "newKategori";
	  }
	  kategoriDao.save(kategori);
	  status.setComplete();
	  return "redirect:viewAllKategori.do";
	 }
	
	@RequestMapping(value="/updateKategori", method=RequestMethod.GET)
	 public ModelAndView editKategori(@RequestParam("idKategori")Integer idKategori)
	 {
	  ModelAndView mav = new ModelAndView("kategori/editKategori");
	  Kategori kategori = kategoriDao.getById(idKategori);
	  mav.addObject("editKategori", kategori);
	  return mav;
	 }
	
	 @RequestMapping(value="/updateKategori", method=RequestMethod.POST)
	 public String update(@ModelAttribute("editKategori") Kategori kategori, BindingResult result, SessionStatus status)
	 {
	  validator.validate(kategori, result);
	  if (result.hasErrors()) {
	   return "editKategori";
	  }
	  kategoriDao.update(kategori);
	  status.setComplete();
	  return "redirect:viewAllKategori.do";
	 }
	 
	 
	 @RequestMapping("deleteKategori")
	 public ModelAndView delete(@RequestParam("idKategori")Integer idKategori){
	  ModelAndView mav = new ModelAndView("redirect:viewAllKategori.do");
	  kategoriDao.delete(idKategori);
	  return mav;
	 }
	
}
