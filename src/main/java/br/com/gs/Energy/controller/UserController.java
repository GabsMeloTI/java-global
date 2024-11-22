package br.com.gs.Energy.controller;

import br.com.gs.Energy.UsuarioService.UsuarioService;
import br.com.gs.Energy.dto.UserForm;
import br.com.gs.Energy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class UserController {


    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("roles", roleRepository.findAll());
        return "user/register";
    }

}
