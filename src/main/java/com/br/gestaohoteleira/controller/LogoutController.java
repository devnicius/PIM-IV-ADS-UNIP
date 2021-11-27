package com.br.gestaohoteleira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

    /**
     * @author Vinícius
     * @see IndexController
     * @apiNote Controlador para a página inicial
     *  */

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String quartos() { return "/login"; }

}