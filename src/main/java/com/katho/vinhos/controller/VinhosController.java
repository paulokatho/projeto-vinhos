package com.katho.vinhos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.katho.vinhos.model.TipoVinho;
import com.katho.vinhos.model.Vinho;
import com.katho.vinhos.repository.Vinhos;

@Controller
public class VinhosController {

	@Autowired
	private Vinhos vinhos;
	
	@GetMapping("/vinhos/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("vinho/cadastro-vinho");
		mv.addObject("tipos", TipoVinho.values());
		return mv;
	}
	
	@PostMapping("/vinhos/novo")
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result) {
		if (result.hasErrors()) {
			 return novo(vinho);
		}
		
		vinhos.save(vinho);
		return new ModelAndView("redirect:/vinhos/novo");
	}
	
	
	
	/**** DA MANEIRA QUE ESTÁ ABAIXO QUANDO O OBJETO VINHO É VALIDADO ELE NÃO MANTEM AS INFORMAÇÕES PREENCHIDAS NOS CAMPOS
	 * SENDO QUE NA FORMA APRENSATADA ACIMA COM ModelAndView É POSSIVEL FAZER A VALIDAÇÃO E RETORNAR PARA O BROWSER AS
	 * INFORMAÇÕES QUE JÁ ESTÃO PREENCHIDAS ****
	 
	@GetMapping("/vinhos/novo")
	public String novo(Model model) {
		model.addAttribute(new Vinho());
		model.addAttribute("tipos", TipoVinho.values());
		return "vinho/cadastro-vinho";
	}
	
	@PostMapping("/vinhos/novo") 
		public String salvar(Vinho vinho) {
			vinhos.save(vinho);
			return "redirect:/vinhos/novo";
		}*/
	
}
