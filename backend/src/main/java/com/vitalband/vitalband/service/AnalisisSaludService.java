package com.vitalband.vitalband.service;

import com.vitalband.vitalband.model.AnalisisSalud;
import com.vitalband.vitalband.repository.AnalisisSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnalisisSaludService {
    @Autowired
    private AnalisisSaludRepository repository;

    public AnalisisSalud guardarAnalisis(AnalisisSalud analisis) {
        analisis.setFecha(LocalDateTime.now());
        return repository.save(analisis);
    }

    public List<AnalisisSalud> obtenerHistorial(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
