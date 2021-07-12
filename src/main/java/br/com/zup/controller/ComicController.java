package br.com.zup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnaudpiroelle.marvel.api.exceptions.AuthorizationException;
import com.arnaudpiroelle.marvel.api.exceptions.EntityNotFoundException;
import com.arnaudpiroelle.marvel.api.exceptions.QueryException;
import com.arnaudpiroelle.marvel.api.exceptions.RateLimitException;

import br.com.zup.controller.dto.ComicDto;
import br.com.zup.form.ComicForm;
import br.com.zup.service.ComicService;

@RestController
@RequestMapping("/comics")
public class ComicController {
	
	@Autowired
	private ComicService service;
	
	@GetMapping
	public List<ComicDto> lista() {
		return ComicDto.converter(service.lista());
	}

	@PostMapping
	public void salvar(@RequestBody ComicForm form)
			throws AuthorizationException, QueryException, RateLimitException, EntityNotFoundException {
		
		service.save(form.getComicId());
	}

}
