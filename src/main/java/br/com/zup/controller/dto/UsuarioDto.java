package br.com.zup.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.modelo.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
