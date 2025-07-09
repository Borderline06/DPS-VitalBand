package com.vitalband.vitalband.controller;

import com.vitalband.vitalband.model.Usuario;
import com.vitalband.vitalband.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado. Revisa tu correo para el código de verificación.");
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verificar(@RequestBody VerificacionRequest request) {
        boolean verificado = usuarioService.verificarUsuario(request.getCorreo(), request.getCodigo());
        if (verificado) {
            return ResponseEntity.ok("Usuario verificado correctamente.");
        }
        return ResponseEntity.badRequest().body("Código incorrecto o usuario no encontrado.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorCorreo(request.getCorreo());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.isVerificado() && usuario.getPassword().equals(request.getPassword())) {
                // Devuelve datos del usuario incluyendo el ID
                return ResponseEntity.ok(new UsuarioResponse(
                    usuario.getId(), 
                    usuario.getNombre(), 
                    usuario.getCorreo()
                ));
            }
        }
        return ResponseEntity.badRequest().body("Correo o contraseña incorrectos, o usuario no verificado.");
    }

    // Clase para enviar datos del usuario
    static class UsuarioResponse {
        private Long id;
        private String nombre;
        private String correo;

        public UsuarioResponse(Long id, String nombre, String correo) {
            this.id = id;
            this.nombre = nombre;
            this.correo = correo;
        }

        public Long getId() { return id; }
        public String getNombre() { return nombre; }
        public String getCorreo() { return correo; }
    }

    static class VerificacionRequest {
        private String correo;
        private String codigo;
        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }
        public String getCodigo() { return codigo; }
        public void setCodigo(String codigo) { this.codigo = codigo; }
    }

    static class LoginRequest {
        private String correo;
        private String password;
        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
