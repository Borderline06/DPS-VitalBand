package com.vitalband.vitalband.repository;

import com.vitalband.vitalband.model.HistorialAnalisis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialAnalisisRepository extends JpaRepository<HistorialAnalisis, Long> {
    List<HistorialAnalisis> findByUsuarioId(Long usuarioId);
}
