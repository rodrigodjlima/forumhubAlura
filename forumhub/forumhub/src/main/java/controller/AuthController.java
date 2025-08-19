
package com.forumhub.controller;

import com.forumhub.model.Usuario;
import com.forumhub.security.TokenService;
import com.forumhub.service.UsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          TokenService tokenService,
                          UsuarioService usuarioService,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario login) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
            );

            String token = tokenService.gerarToken(auth);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;

        } catch (AuthenticationException e) {
            Map<String, String> response = new HashMap<>();
            response.put("erro", "Usuário ou senha inválidos");
            return response;
        }
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) {
        // Criptografa a senha antes de salvar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioService.salvar(usuario);
    }
}