package com.sha.gestaoHoteleira.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vinicius
 * @date 28.08.2021
 * @time 00:00
 */
@RestController
public class ApiController
{
    @GetMapping("api/health")
    public ResponseEntity<?> healthCheck()
    {
        return ResponseEntity.ok("Está funcionando!");
    }
}
