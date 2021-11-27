package com.br.gestaohoteleira.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.val;

    /**
     * @author Vinícius
     * @see LoginController
     * @apiNote Controlador para redirecionar entre as páginas inicial, login e após o login (recepcionista, gerente e administrador)
     *  */

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() { 
        return "login"; 
    }

    @RequestMapping("/user")
    public String pagina() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        val value = auth.getAuthorities();

        //Faz verificações utilizando stream() a fim de pegar a autoridade respectiva do login para redirecionar à página correta.
        if (value.stream().anyMatch(a -> a.getAuthority().equals("REC"))) {
            return "recepcionista";
        } else if (value.stream().anyMatch(a -> a.getAuthority().equals("GER"))) {
            return "gerente";
        } else if (value.stream().anyMatch(a -> a.getAuthority().equals("ADM"))) {
            return "administrador";
           }   else { return login(); } 
    }
}