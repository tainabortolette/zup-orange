package br.com.zup.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UsuarioForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String cpf;
	
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull @NotEmpty
	private String email;

}
