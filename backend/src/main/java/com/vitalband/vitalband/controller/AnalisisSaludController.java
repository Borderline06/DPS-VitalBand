package com.vitalband.vitalband.controller;

import com.vitalband.vitalband.model.AnalisisSalud;
import com.vitalband.vitalband.service.AnalisisSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analisis")
@CrossOrigin(origins = "*")
public class AnalisisSaludController {
    @Autowired
    private AnalisisSaludService service;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody AnalisisSalud analisis) {
        AnalisisSalud guardado = service.guardarAnalisis(analisis);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<?> historial(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.obtenerHistorial(usuarioId));
    }
}
