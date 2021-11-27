package com.br.gestaohoteleira.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

    /**
     * @author Vinícius
     * @see IndexController
     * @apiNote Controlador para a página inicial
     *  */

@Controller
@RequestMapping("/ajuda")
public class AjudaController {
    @PreAuthorize("hasAuthority('REC')")
    @RequestMapping
    public String quartos() { return "/pages/recepcionista/quartos/quartos.html"; }
}