package com.katho.vinhos.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SegurancaController {
	
	/* @AuthenticationPrincipal entrega a sessão para o spring, é possivel pegar a sessão, o nome do usuario e etc.
		essa anotação também é possível utilizar em qualquer controlador. 
		Também é possivel estender essa classe User e criar seu próprio User para obter mais informações, por exemplo
		outras informações do usuário que você deseje.
	*/
	
	@RequestMapping("/login")
	public String login(@AuthenticationPrincipal User user) {
		if (user != null) {
			return "redirect:/vinhos";
		}
		return "login";
	}

}
