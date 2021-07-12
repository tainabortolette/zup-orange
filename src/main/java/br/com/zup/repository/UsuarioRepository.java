package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
