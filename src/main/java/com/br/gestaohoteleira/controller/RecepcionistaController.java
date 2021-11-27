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
@RequestMapping("/recepcionista")
public class RecepcionistaController {
    @PreAuthorize("hasAuthority('REC')")
    @RequestMapping("/quartos")
    public String quartos() { return "/pages/recepcionista/quartos/quartos.html"; }

    @PreAuthorize("hasAuthority('REC')")
    @RequestMapping("/reservas")
    public String reservas() { return "/pages/recepcionista/reservas/reservas.html"; }

    @PreAuthorize("hasAuthority('REC')")
    @RequestMapping("/listarhospedes")
    public String hospedesListar() { return "/pages/recepcionista/listarhospedes.html"; }

    @PreAuthorize("hasAuthority('REC')")
    @RequestMapping("/cadastrarhospede")
    public String hospedesCadastrar() { return "/pages/recepcionista/cadastrarhospede.html"; }

    @PreAuthorize("hasAuthority('REC')")
    @RequestMapping("/alterarhospede")
    public String hospedesAlterar() { return "/pages/recepcionista/alterarcadhospede.html"; }
}