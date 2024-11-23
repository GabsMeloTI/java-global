package br.com.gs.Energy.controller;

import br.com.gs.Energy.UsuarioService.UsuarioService;
    import br.com.gs.Energy.dto.UserForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cadastro de Post",
            description = "Cadastra um Post")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Cadastro com Sucesso", content =
    @Content(schema = @Schema(implementation = UserForm.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})

    public String registerUser(@ModelAttribute("userForm") UserForm userForm) {
        usuarioService.saveUser(userForm.getUsername(),
                passwordEncoder.encode(userForm.getPassword()), userForm.getRoles());
        return "redirect:/login";
    }
}