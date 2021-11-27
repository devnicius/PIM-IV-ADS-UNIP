package com.br.gestaohoteleira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

    /**
     * @author Vinícius
     * @see IndexController
     * @apiNote Controlador para a página inicial
     *  */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() { return "index"; }
}