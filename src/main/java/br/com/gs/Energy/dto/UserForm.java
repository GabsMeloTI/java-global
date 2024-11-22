package br.com.gs.Energy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class UserForm {
    private String username;
    private String password;
    private String cpf;
    private String email;

    private List<String> roles;
}
