package com.vitalband.vitalband.controller;

import com.vitalband.vitalband.model.HistorialAnalisis;
import com.vitalband.vitalband.service.HistorialAnalisisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial-analisis")
public class HistorialAnalisisController {

    private final HistorialAnalisisService historialService;

    @Autowired
    public HistorialAnalisisController(HistorialAnalisisService historialService) {
        this.historialService = historialService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HistorialAnalisis>> obtenerHistorialPorUsuario(@PathVariable Long usuarioId) {
        List<HistorialAnalisis> historial = historialService.buscarPorUsuarioId(usuarioId);
        if (historial.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historial);
    }
}
