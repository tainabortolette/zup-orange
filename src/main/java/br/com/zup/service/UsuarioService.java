package br.com.zup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.modelo.Usuario;
import br.com.zup.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> lista() {
		return repository.findAll();
	}
	
	public void save(Usuario usuario) {
		repository.save(usuario);
	}

}
