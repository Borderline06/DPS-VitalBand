package com.vitalband.vitalband.service;

import com.vitalband.vitalband.model.Usuario;
import com.vitalband.vitalband.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setVerificado(false);
        usuario.setCodigoVerificacion(generarCodigo());
        return usuarioRepository.save(usuario);
    }

    public boolean verificarUsuario(String correo, String codigo) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoAndCodigoVerificacion(correo, codigo);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setVerificado(true);
            usuario.setCodigoVerificacion(null);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    public boolean validarLogin(String correo, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.isVerificado() && usuario.getPassword().equals(password);
        }
        return false;
    }

    // Nuevo método para obtener usuario por correo
    public Optional<Usuario> obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    private String generarCodigo() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }
}

