package com.vitalband.vitalband.repository;

import com.vitalband.vitalband.model.AnalisisSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnalisisSaludRepository extends JpaRepository<AnalisisSalud, Long> {
    List<AnalisisSalud> findByUsuarioId(Long usuarioId);
}
