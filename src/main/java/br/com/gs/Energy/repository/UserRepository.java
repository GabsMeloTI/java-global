package br.com.gs.Energy.repository;

import br.com.gs.Energy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Corrigido
}
