package br.com.gs.Energy.controller;

import br.com.gs.Energy.UsuarioService.UsuarioService;
import br.com.gs.Energy.dto.UserForm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/logar")
    public String registerUser(@ModelAttribute("userForm") UserForm userForm) {
        usuarioService.saveUser(userForm.getUsername(),
                passwordEncoder.encode(userForm.getPassword()), userForm.getRoles());
        return "redirect:/login";
    }
}
