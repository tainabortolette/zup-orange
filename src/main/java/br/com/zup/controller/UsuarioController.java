package br.com.zup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controller.dto.UsuarioDto;
import br.com.zup.form.UsuarioForm;
import br.com.zup.modelo.Usuario;
import br.com.zup.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<UsuarioDto> lista() {
		return UsuarioDto.converter(service.lista());
	}
	
	@PostMapping
	public void salvar(@Valid @RequestBody UsuarioForm form) {
		
		service.save(Usuario.builder()
				.nome(form.getNome())
				.cpf(form.getCpf())
				.email(form.getEmail())
				.dataNascimento(form.getDataNascimento())
				.build());
	}

}
