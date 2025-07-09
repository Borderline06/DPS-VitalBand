package com.vitalband.vitalband.repository;



import com.vitalband.vitalband.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByCorreoAndCodigoVerificacion(String correo, String codigoVerificacion);
}
