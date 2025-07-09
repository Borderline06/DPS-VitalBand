package com.vitalband.vitalband.service;

import com.vitalband.vitalband.model.HistorialAnalisis;
import com.vitalband.vitalband.repository.HistorialAnalisisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialAnalisisService {

    private final HistorialAnalisisRepository historialRepository;

    @Autowired
    public HistorialAnalisisService(HistorialAnalisisRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<HistorialAnalisis> buscarPorUsuarioId(Long usuarioId) {
        return historialRepository.findByUsuarioId(usuarioId);
    }
}